package com.suseong.ticketsuseongspring;

import com.suseong.ticketsuseongspring.login.ActionLogin;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author : iyeong-gyo
 * @package : com.suseong.ticketsuseongspring
 * @since : 2023/03/25
 */
@Slf4j
@RequiredArgsConstructor
@Component
public class StartTicketProcess {

  @Value("${login.url}")
  private String loginUrl;
  private final WebDriver driver;
  private final ActionLogin login;

  public void start() {
    driver.get(loginUrl);
    login.startLogin();
  }
}
