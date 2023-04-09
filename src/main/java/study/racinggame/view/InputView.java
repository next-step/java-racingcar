package study.racinggame.view;

import java.util.Scanner;

public class InputView {

  private final static Scanner scanner = new Scanner(System.in);
  private final static String carMessage = "자동차 대수는 몇 대 인가요?";
  private final static String tryMessage = "시도할 횟수는 몇 회 인가요?";
  private final static int POSITIVE_MINIMUM = 1;

  public static int inputCarNumber() {
    System.out.println(carMessage);
    return validatedNumber(scanner.nextInt());
  }

  public static int inputTryNumber() {
    System.out.println(tryMessage);
    return validatedNumber(scanner.nextInt());
  }

  private static int validatedNumber(int number) {
    if (!isPositive(number)) {
      throw new IllegalArgumentException("1회 이상만 입력 가능합니다.");
    }

    return number;
  }

  private static boolean isPositive(int number) {
    return number >= POSITIVE_MINIMUM;
  }
}
