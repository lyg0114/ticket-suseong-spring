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
  public void start() {
    int retryCnt = 0;
    boolean confirm = false;

    while (retryCnt < 5 || confirm) {
      try {
        driver = InitDriver.getDriver();
        driver.get(global.getLoginUrl());
        login.startLogin(driver, global.getUserId(), global.getUserPw());
        goToYoGaPage();
        checkPersonalInfo();
        confirmReservation();
        clickConfirmAlert();
        confirm = true;
      } catch (RuntimeException ex) {
        log.error(ex.getMessage() + " retry : " + (++retryCnt));
      }
    }
  }

  private void clickConfirmAlert() {
    Alert alert = driver.switchTo().alert();
    alert.accept();
  }

  private void confirmReservation() {
    WebElement clickReserviationBtn = driver.findElement(By.xpath(global.getReservationBtnXpath()));
    String BtnText = clickReserviationBtn.getText();
    if (!BtnText.equals("신청하기")) {
      throw new RuntimeException("There is no clickReserviationBtn");
    }

    new Actions(driver)
        .moveToElement(clickReserviationBtn)
        .click()
        .perform()
    ;
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
