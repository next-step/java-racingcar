package racing.utils;

import java.util.List;

public final class StringUtils {
  public static final String DEFAULT_SEPARATOR = ",";

  private StringUtils() {
  }

  public static String[] split(String str) {
    return split(str, DEFAULT_SEPARATOR);
  }

  public static String[] split(String str, String separator) {
    if (isBlank(str)) {
      return new String[]{};
    }

    return str.split(separator);
  }

  public static List<String> toList(String str) {
    return toList(str, DEFAULT_SEPARATOR);
  }

  public static List<String> toList(String str, String separator) {
    return ListUtils.of(split(str, separator));
  }


  public static boolean isBlank(String str) {
    return str == null || str.trim().isEmpty();
  }

  public static String defaultString(String str) {
    if (StringUtils.isBlank(str)) {
      return "";
    }
    return str;
  }

  public static String repeatString(String symbol, int repeat) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < repeat; i++) {
      sb.append(symbol);
    }
    return sb.toString();
  }

  public static String trim(String str) {
    return defaultString(str).trim();
  }
}
