package step2;

public final class StringUtils {

  public static String[] split(String str, String separator) {
    if (isBlank(str))
      return new String[]{};

    return str.split(separator);
  }

  public static boolean isBlank(String str) {
    return str == null || str.trim().isEmpty();
  }
}
