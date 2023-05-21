package com.suseong.ticketsuseongspring.controller;

import com.suseong.ticketsuseongspring.StartProcess;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : iyeong-gyo
 * @package : com.suseong.ticketsuseongspring.controller
 * @since : 2023/05/21
 */
@RequiredArgsConstructor
@RestController
public class ReservationController {

  private final StartProcess startProcess;

  @GetMapping("/start-res-1")
  public String testCron1() {
    String userId = "lyg1029";
    String userPw = "chojungs8928";
    startProcess.start(userId, userPw);

    userId = "chojungs";
    userPw = "chojungs8928";
    startProcess.start(userId, userPw);
    return "SUCCESS";
  }
}
