package study.racing.view;

import java.util.Scanner;

public final class InputView {

  public static final String QUESTION_CAR_NAMES = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
  public static final String QUESTION_TRY_COUNT = "시도할 횟수는 몇 회 인가요?";

  private static Scanner scanner = new Scanner(System.in);

  public static String[] getCarNames() {
    System.out.println(QUESTION_CAR_NAMES);
    String names = scanner.nextLine();
    return names.split(",");
  }

  public static int getTryCount() {
    System.out.println(QUESTION_TRY_COUNT);
    return scanner.nextInt();
  }

}
