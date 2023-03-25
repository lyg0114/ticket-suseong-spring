package com.suseong.ticketsuseongspring.login;

import com.suseong.ticketsuseongspring.conf.Global;
import java.time.Duration;
import lombok.RequiredArgsConstructor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author : iyeong-gyo
 * @package : PACKAGE_NAME
 * @since : 2023/03/25
 */
@RequiredArgsConstructor
@Component
public class ActionLogin {

  @Value("${login.url}")
  private String loginUrl;
  @Value("${target.id}")
  private String userId;
  @Value("${target.pw}")
  private String userPw;

  private Duration delay = Duration.ofMillis(10);
  private final WebDriver driver;

  public void startLogin() {
    driver.get(loginUrl);
    WebElement elementID = driver.findElement(By.id("id"));
    WebElement elementPw = driver.findElement(By.id("password"));
    WebElement elementBtn = driver.findElement(By.xpath(Global.LOGIN_BTN_PATH));

    new Actions(driver)
        .moveToElement(elementID)
        .pause(delay)
        .clickAndHold()
        .pause(delay)
        .sendKeys(userId) // add id

        .moveToElement(elementPw)
        .pause(delay)
        .clickAndHold()
        .pause(delay)
        .sendKeys(userPw) // add pw

        .moveToElement(elementBtn) // click sumit btn
        .pause(delay)
        .click()
        .perform();
  }
}
