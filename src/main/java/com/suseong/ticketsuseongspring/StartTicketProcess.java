package com.suseong.ticketsuseongspring;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author : iyeong-gyo
 * @package : com.suseong.ticketsuseongspring
 * @since : 2023/03/25
 */
@Slf4j
@Component
public class StartTicketProcess {

  @Value("${my.service.url}")
  private String url;

  public void start() {
  }
}
