package com.suseong.ticketsuseongspring.util;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 * @author : iyeong-gyo
 * @package : com.suseong.ticketsuseongspring.util
 * @since : 2023/05/21
 */
public class InitDriver {

  public static ChromeDriver getDriver() {
    return new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*"));
  }
}
