package com.suseong.ticketsuseongspring;

import com.suseong.ticketsuseongspring.action.ActionLogin;
import com.suseong.ticketsuseongspring.conf.GlobalVar;
import com.suseong.ticketsuseongspring.conf.InitDriver;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.springframework.stereotype.Component;

/**
 * @author : iyeong-gyo
 * @package : com.suseong.ticketsuseongspring
 * @since : 2023/03/25
 */
@Slf4j
@RequiredArgsConstructor
@Component
public class StartTicketProcess implements StartProcess {

  private WebDriver driver;
  private final GlobalVar global;
  private final ActionLogin login;

  @Override
  public void start(String userId, String userPw) {
    driver = InitDriver.getDriver();
    driver.get(global.getLoginUrl());
    login.startLogin(driver, userId, userPw);
    goToYoGaPage();
    checkPersonalInfo();
    confirmReservation();
    clickConfirmAlert();
  }


  private void clickConfirmAlert() {
    Alert alert = driver.switchTo().alert();
    alert.accept();
  }

  private void confirmReservation() {
    WebElement clickReserviationBtn = driver.findElement(By.xpath(global.getReservationBtnXpath()));
    new Actions(driver)
        .moveToElement(clickReserviationBtn)
        .click()
        .perform();
  }

  private void goToYoGaPage() {
    WebElement goSanBtn = driver.findElement(By.xpath(global.getSelectCenterXpath()));
    new Actions(driver)
        .moveToElement(goSanBtn)
        .click()
        .perform();
  }

  private void checkPersonalInfo() {
    driver.get(global.getTargetUrl());
    WebElement personalInfoCheckBtn = driver
        .findElement(By.xpath(global.getPersonalInfoCheckXPath()));
    new Actions(driver)
        .moveToElement(personalInfoCheckBtn)
        .click()
        .perform();
  }
}
