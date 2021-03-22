package step5.util;

public class Strings {

  private static String INPUT_ERROR_CAR_FULL_NAMES = "입력된 차량들의 전체 이름이 잘못 되었습니다.";

  private Strings() {
  }

  public static boolean checkNotNullOrNotEmpty(String str) {
    return str != null && !str.trim().isEmpty();
  }

  public static void isValidCarNames(String carNames) {
    if (!Strings.checkNotNullOrNotEmpty(carNames)) {
      throw new IllegalArgumentException(INPUT_ERROR_CAR_FULL_NAMES);
    }

  }
}
