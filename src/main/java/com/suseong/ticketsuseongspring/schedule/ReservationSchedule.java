package com.suseong.ticketsuseongspring.schedule;

import com.suseong.ticketsuseongspring.StartProcess;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : iyeong-gyo
 * @package : com.suseong.ticketsuseongspring.controller
 * @since : 2023/05/21
 */
@RequiredArgsConstructor
@EnableScheduling
@Component
public class ReservationSchedule {

  private final StartProcess startProcess;

  @Scheduled(cron = "0 0 9 * * ?")
  public String testCron() {
    startProcess.start();
    return "SUCCESS";
  }
}
