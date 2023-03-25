package com.suseong.ticketsuseongspring;

import com.suseong.ticketsuseongspring.conf.Global;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TicketSuseongSpringApplication {

  public static void main(String[] args) {
    System.setProperty(Global.DRIVER_NAME, Global.DRIVER_PATH);
    SpringApplication.run(TicketSuseongSpringApplication.class, args)
        .getBean(StartTicketProcess.class)
        .start();
  }

  @Bean
  public WebDriver webDriver() {
    return new ChromeDriver(chromeOptions());
  }

  @Bean
  public ChromeOptions chromeOptions() {
    return new ChromeOptions().addArguments("--remote-allow-origins=*");
  }
}
