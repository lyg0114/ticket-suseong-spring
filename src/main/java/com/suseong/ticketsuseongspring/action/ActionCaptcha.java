package com.suseong.ticketsuseongspring.action;

import com.suseong.ticketsuseongspring.conf.GlobalVar;
import lombok.RequiredArgsConstructor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

/**
 * @author : iyeong-gyo
 * @package : com.suseong.ticketsuseongspring.action
 * @since : 2023/03/27
 */
@RequiredArgsConstructor
@Component
public class ActionCaptcha {

  private final GlobalVar global;
  private final WebDriver driver;

  public void translateCaptcha() {
    WebElement elementCaptcha = driver.findElement(By.xpath(global.getCaptchaXpaht()));
    extractedCaptchaStr(elementCaptcha);
  }

  private String extractedCaptchaStr(WebElement elementCaptcha) {
    String plainStr = elementCaptcha.getAttribute("style");
    String split = plainStr.split(",")[1];
    String captchaStr = split.split("\"")[0];
    return captchaStr;
  }

}
