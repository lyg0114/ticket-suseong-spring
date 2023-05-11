package com.suseong.ticketsuseongspring;

import com.suseong.ticketsuseongspring.action.ActionLogin;
import com.suseong.ticketsuseongspring.conf.GlobalVar;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/**
 * @author : iyeong-gyo
 * @package : com.suseong.ticketsuseongspring
 * @since : 2023/03/25
 */
@Profile("ticket")
@Slf4j
@RequiredArgsConstructor
@Component
public class StartTicketProcess implements StartProcess {

  private final GlobalVar global;
  private final WebDriver driver;
  private final ActionLogin login;

  private final String goSanBtnXPath = "/html/body/s/div[2]/div/div[1]/div/a/span";
  private final String personalInfoCheckXPath = "/html/body/form/div[1]/div[2]/div/table/tbody/tr[15]/td/p/input";

  @Override
  public void start() {
    driver.get(global.getLoginUrl());
    login.startLogin();
    goToYoGaPage();
    checkPersonalInfo();
  }

  private void goToYoGaPage() {
    WebElement goSanBtn = driver.findElement(By.xpath(goSanBtnXPath));
    new Actions(driver)
        .moveToElement(goSanBtn)
        .click()
        .perform();
  }

  private void checkPersonalInfo() {
    driver.get(global.getTargetUrl());
    WebElement personalInfoCheckBtn = driver.findElement(By.xpath(personalInfoCheckXPath));
    new Actions(driver)
        .moveToElement(personalInfoCheckBtn)
        .click()
        .perform();
  }
}
