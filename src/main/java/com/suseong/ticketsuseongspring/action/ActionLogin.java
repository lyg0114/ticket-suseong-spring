package com.suseong.ticketsuseongspring.action;

import com.suseong.ticketsuseongspring.conf.GlobalVar;
import lombok.RequiredArgsConstructor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.springframework.stereotype.Component;

/**
 * @author : iyeong-gyo
 * @package : PACKAGE_NAME
 * @since : 2023/03/25
 */
@RequiredArgsConstructor
@Component
public class ActionLogin {

  private final GlobalVar global;

  public void startLogin(WebDriver driver) {
    driver.get(global.getLoginUrl());
    WebElement elementID = driver.findElement(By.xpath(global.getLoginIdXpath()));
    WebElement elementPw = driver.findElement(By.xpath(global.getLoginPwXpath()));
    WebElement elementBtn = driver.findElement(By.xpath(global.getLoginBtnXpath()));

    new Actions(driver)
        .moveToElement(elementID)
        .pause(GlobalVar.COMMON_DELAY)
        .clickAndHold()
        .pause(GlobalVar.COMMON_DELAY)
        .sendKeys(global.getUserId())

        .moveToElement(elementPw)
        .pause(GlobalVar.COMMON_DELAY)
        .clickAndHold()
        .pause(GlobalVar.COMMON_DELAY)
        .sendKeys(global.getUserPw())

        .moveToElement(elementBtn)
        .pause(GlobalVar.COMMON_DELAY)
        .click()
        .perform();
  }
}
