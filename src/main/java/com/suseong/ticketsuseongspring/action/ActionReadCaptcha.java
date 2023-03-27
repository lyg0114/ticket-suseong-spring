package com.suseong.ticketsuseongspring.action;

import com.suseong.ticketsuseongspring.conf.GlobalVar;
import java.io.File;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.springframework.stereotype.Component;

/**
 * @author : iyeong-gyo
 * @package : com.suseong.ticketsuseongspring.action
 * @since : 2023/03/27
 */
@Slf4j
@RequiredArgsConstructor
@Component
public class ActionReadCaptcha {

  private final GlobalVar global;
  private final Tesseract tesseract;

  public String readCaptcha() {
    File imageFile = new File(GlobalVar.CAPTCHA_PATH);
    tesseract.setDatapath(global.getDataPath());
    tesseract.setLanguage(GlobalVar.LANGUAGE_TAG);
    try {
      String result = tesseract.doOCR(imageFile);
      log.info("=========================");
      log.info(result);
      log.info("=========================");
      return result;
    } catch (TesseractException e) {
      log.error(e.getMessage());
      throw new NullPointerException(e.getMessage());
    }
  }
}
