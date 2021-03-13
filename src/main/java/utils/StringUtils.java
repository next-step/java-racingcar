package utils;

public final class StringUtils {

  private StringUtils() {
  }

  public static String[] split(String str, String separator) {
    if (isBlank(str)) {
      return new String[]{};
    }

    return str.split(separator);
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
