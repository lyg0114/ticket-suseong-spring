package com.suseong.ticketsuseongspring;

import com.suseong.ticketsuseongspring.action.ActionReadCaptcha;
import com.suseong.ticketsuseongspring.action.ActionSaveCaptcha;
import com.suseong.ticketsuseongspring.conf.GlobalVar;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/**
 * @author : iyeong-gyo
 * @package : com.suseong.ticketsuseongspring
 * @since : 2023/03/25
 */
@Profile("de")
@Slf4j
@RequiredArgsConstructor
@Component
public class StartDeProcess implements StartProcess {

  private final GlobalVar global;
  private final WebDriver driver;
  private final ActionSaveCaptcha actionSaveCaptcha;
  private final ActionReadCaptcha actionReadCaptcha;

  @Override
  public void start() {
    driver.get(global.getTargetUrl());
    actionSaveCaptcha.saveCaptchaFromWeb();
    actionReadCaptcha.readCaptcha();
  }
}
