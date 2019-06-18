package racinggame.util;

public class StringUtil {
  private static final String CAR_RACING_PRINT = "-";

  public static String getCarRacingPrint(int repeat) {
    StringBuilder stringBuilder = new StringBuilder();
    for (int i = 0; i < repeat; i++) {
      stringBuilder.append("-");
    }
    return stringBuilder.toString();
  }
}
