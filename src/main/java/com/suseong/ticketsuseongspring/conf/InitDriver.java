package com.suseong.ticketsuseongspring.conf;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 * @author : iyeong-gyo
 * @package : com.suseong.ticketsuseongspring.util
 * @since : 2023/05/21
 */
public class InitDriver {

  public static ChromeDriver getDriver() {
    return new ChromeDriver(getOptions());
  }

  private static ChromeOptions getOptions() {
    return new ChromeOptions()
        .addArguments("--remote-allow-origins=*")
        .setHeadless(true)
        ;
  }
}
