package study.step2;

public class Utils {

  public static String[] getTokens(String inputText) {
    return inputText.trim().split(" ");
  }

  public static void isEmptyOrNull(String value) {
    if (value == null || "".equals(value)) {
      throw new IllegalArgumentException();
    }
  }

}
