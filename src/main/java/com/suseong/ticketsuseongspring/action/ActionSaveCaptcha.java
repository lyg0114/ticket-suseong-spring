package com.suseong.ticketsuseongspring.action;

import com.suseong.ticketsuseongspring.conf.GlobalVar;
import java.io.FileOutputStream;
import java.util.Base64;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

/**
 * @author : iyeong-gyo
 * @package : com.suseong.ticketsuseongspring.action
 * @since : 2023/03/27
 */
@Slf4j
@RequiredArgsConstructor
@Component
public class ActionSaveCaptcha {

  private final GlobalVar global;
  private final WebDriver driver;

  public void translateCaptcha() {
    WebElement elementCaptcha = driver.findElement(By.xpath(global.getCaptchaXpaht()));
    byte[] decodedImage = Base64
        .getDecoder()
        .decode(extractedCaptchaStr(elementCaptcha));

    try (FileOutputStream imageOutput = new FileOutputStream(
        "/Users/iyeong-gyo/Desktop/study/toy-study/ticket-suseong-spring/src/main/resources/captcha.png")) {
      imageOutput.write(decodedImage);
      log.info("CAPTCHA image save success");
    } catch (Exception e) {
      log.error("CAPTCHA image save fail");
      e.printStackTrace();
    }
  }

  private String extractedCaptchaStr(WebElement elementCaptcha) {
    String plainStr = elementCaptcha.getAttribute("style");
    String split = plainStr.split(",")[1];
    String captchaStr = split.split("\"")[0];
    return captchaStr;
  }
}
