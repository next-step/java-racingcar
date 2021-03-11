package study.racing;

import java.util.Scanner;

public final class InputView {

  public static final String QUESTION_CAR_COUNT = "자동차 대수는 몇대인가요?";
  public static final String QUESTION_TRY_COUNT = "시도할 횟수는 몇 회 인가요?";

  private static Scanner scanner = new Scanner(System.in);

  public static int getCarCount() {
    System.out.println(QUESTION_CAR_COUNT);
    return scanner.nextInt();
  }

  public static int getTryCount() {
    System.out.println(QUESTION_TRY_COUNT);
    return scanner.nextInt();
  }

}
