package com.suseong.ticketsuseongspring;

import com.suseong.ticketsuseongspring.conf.GlobalVar;
import net.sourceforge.tess4j.Tesseract;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TicketSuseongSpringApplication {

  public static void main(String[] args) {
    System.setProperty(GlobalVar.DRIVER_NAME, GlobalVar.DRIVER_PATH);
    SpringApplication.run(TicketSuseongSpringApplication.class, args)
        .getBean(StartProcess.class)
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

  @Bean
  public Tesseract tesseract() {
    return new Tesseract();
  }
}
