package racinggame.util;

public class StringUtil {
  private static final String CAR_RACING_PRINT = "-";
  private static final int START_INDEX = 0;

  public static String getCarRacingPrint(int repeat) {
    StringBuilder stringBuilder = new StringBuilder();
    for (int i = START_INDEX; i < repeat; i++) {
      stringBuilder.append(CAR_RACING_PRINT);
    }
    return stringBuilder.toString();
  }
}
