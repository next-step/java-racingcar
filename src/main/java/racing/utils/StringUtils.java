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
    return ListUtils.of(split(str));
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

}
