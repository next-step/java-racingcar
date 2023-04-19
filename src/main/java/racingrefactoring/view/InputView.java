package racingrefactoring.view;

import java.util.Scanner;

public class InputView {

  private static final String INPUT_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
  private static final String INPUT_ROUND_MESSAGE = "시도할 회수는 몇회인가요?";

  private final static Scanner scanner = new Scanner(System.in);
  public static String scanCarNames() {
    println(INPUT_CAR_NAMES_MESSAGE);
    return scanner.nextLine();
  }

  public static int scanRound() {
    println(INPUT_ROUND_MESSAGE);
    return scanner.nextInt();
  }

  private static void println(String message) {
    System.out.println(message);
  }
}
