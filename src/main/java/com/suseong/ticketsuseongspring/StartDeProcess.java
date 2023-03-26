package com.suseong.ticketsuseongspring;

import com.suseong.ticketsuseongspring.action.ActionCaptcha;
import com.suseong.ticketsuseongspring.conf.GlobalVar;
import com.suseong.ticketsuseongspring.action.ActionLogin;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.springframework.stereotype.Component;

/**
 * @author : iyeong-gyo
 * @package : com.suseong.ticketsuseongspring
 * @since : 2023/03/25
 */
@Slf4j
@RequiredArgsConstructor
@Component
public class StartDeProcess implements StartProcess {

  private final GlobalVar global;
  private final WebDriver driver;
  private final ActionCaptcha actionCaptcha;

  @Override
  public void start() {
    driver.get(global.getTargetUrl());
    actionCaptcha.translateCaptcha();
  }
}
