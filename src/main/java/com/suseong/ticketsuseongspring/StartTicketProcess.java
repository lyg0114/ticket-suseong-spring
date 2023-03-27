package com.suseong.ticketsuseongspring;

import com.suseong.ticketsuseongspring.action.ActionLogin;
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
@Profile("ticket")
@Slf4j
@RequiredArgsConstructor
@Component
public class StartTicketProcess implements StartProcess {

  private final GlobalVar global;
  private final WebDriver driver;
  private final ActionLogin login;

  @Override
  public void start() {
    driver.get(global.getLoginUrl());
    login.startLogin();
  }
}
