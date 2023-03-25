package com.suseong.ticketsuseongspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class TicketSuseongSpringApplication {
  public static void main(String[] args) {
    ConfigurableApplicationContext run = SpringApplication
        .run(TicketSuseongSpringApplication.class, args);
  }
}
