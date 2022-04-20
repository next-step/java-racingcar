package racingCar.util;

import java.util.Collections;
import java.util.List;

public final class StringUtils {

  public static String join(List<String> strings) {
    return String.join(", ", strings);
  }

  public static String[] split(String str, String regex) {
    return str.split(regex);
  }
}
