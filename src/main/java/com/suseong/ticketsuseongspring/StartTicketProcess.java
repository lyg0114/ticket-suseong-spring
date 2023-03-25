package com.suseong.ticketsuseongspring;

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

  private final WebDriver driver;

  @Value("${login.url}")
  private String loginUrl;

  public void start() {
    driver.get(loginUrl);
  }
}
