package study.step2;

import org.apache.commons.lang3.StringUtils;

public class Utils {

  public static String[] getTokens(String inputText) {
    if (StringUtils.isEmpty(inputText)) {
      throw new IllegalArgumentException();
    }

    return inputText.trim().split(" ");
  }

}
