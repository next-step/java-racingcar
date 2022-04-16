package racingcar.ui;

import java.util.Scanner;

public class InputView {

  private static final Scanner SCANNER = new Scanner(System.in);

  private InputView() {
  }

  public static int getIntInput() {
    int input = SCANNER.nextInt();
    if (input < 1) {
      throw new RuntimeException("1보다 작은 숫자는 입력할 수 없습니다.");
    }
    return input;
  }

  public static void printCountQuestion() {
    System.out.println("자동차 대수는 몇 대 인가요?");
  }

  public static void printTimesQuestion() {
    System.out.println("시도할 회수는 몇회인가요?");
  }
}
