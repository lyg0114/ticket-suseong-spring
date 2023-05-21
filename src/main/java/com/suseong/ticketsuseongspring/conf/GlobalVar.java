package com.suseong.ticketsuseongspring.conf;

import java.time.Duration;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author : iyeong-gyo
 * @package : com.suseong.ticketsuseongspring.conf
 * @since : 2023/03/25
 */
@Getter
@Component
public class GlobalVar {

  public static String LANGUAGE_TAG = "eng";
  public static Duration COMMON_DELAY = Duration.ofMillis(10);

  public static String DRIVER_NAME = "webdriver.chrome.driver";
  public static String RESOURCE_PATH = "/Users/iyeong-gyo/Desktop/study/toy-study/ticket-suseong-spring/src/main/resources";
  public static String DRIVER_PATH = RESOURCE_PATH + "/chromedriver";
  public static String CAPTCHA_PATH = RESOURCE_PATH + "/captcha.jpeg";

  @Value("${target.url}")
  private String targetUrl;
  @Value("${select.center.xpath}")
  private String selectCenterXpath;
  @Value("${personal.info.check.xpath}")
  private String personalInfoCheckXPath;
  @Value("${reserve.btn.xpath}")
  private String reservationBtnXpath;


  @Value("${login.url}")
  private String loginUrl;
  @Value("${target.id}")
  private String userId;
  @Value("${target.pw}")
  private String userPw;
  @Value("${login.id.xpath}")
  private String loginIdXpath;
  @Value("${login.pw.xpath}")
  private String loginPwXpath;
  @Value("${login.btn.xpath}")
  private String loginBtnXpath;
  @Value("${captcha.xpath}")
  private String captchaXpaht;
  @Value("${tesseract.dataPath}")
  private String dataPath;

}
