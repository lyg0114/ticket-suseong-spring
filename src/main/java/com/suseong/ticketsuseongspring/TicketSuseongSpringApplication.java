package com.suseong.ticketsuseongspring;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TicketSuseongSpringApplication {

  public static void main(String[] args) {
    setUp();
    ConfigurableApplicationContext run = SpringApplication
        .run(TicketSuseongSpringApplication.class, args);
    StartTicketProcess process = run.getBean(StartTicketProcess.class);
    process.start();
  }

  private static void setUp() {
    System.setProperty("webdriver.chrome.driver",
        "/Users/iyeong-gyo/Desktop/study/toy-study/ticket-suseong/chromedriver");
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
