package com.suseong.ticketsuseongspring;

import com.suseong.ticketsuseongspring.conf.GlobalVar;
import net.sourceforge.tess4j.Tesseract;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TicketSuseongSpringApplication {

  public static void main(String[] args) {
    System.setProperty(GlobalVar.DRIVER_NAME, GlobalVar.DRIVER_PATH);
    SpringApplication.run(TicketSuseongSpringApplication.class, args)
    ;
  }

  @Bean
  public Tesseract tesseract() {
    return new Tesseract();
  }
}
