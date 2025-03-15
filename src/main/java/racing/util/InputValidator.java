package racing.util;

public class InputValidator {

  private static final int MIN_CAR_COUNT = 2;
  private static final int MIN_SIMULATE_COUNT = 1;

  public static void checkNotValidCarCount(int carCount) {
    if (carCount < MIN_CAR_COUNT) {
      throw new IllegalArgumentException("자동차 수는 최소 " + MIN_CAR_COUNT + "대여야 합니다.");
    }
  }

  public static void checkNotValidSimulateCount(int simulateCount) {
    if (simulateCount < MIN_SIMULATE_COUNT) {
      throw new IllegalArgumentException("시뮬레이션 횟수는 최소 " + MIN_SIMULATE_COUNT + "회여야 합니다.");
    }
  }
}
