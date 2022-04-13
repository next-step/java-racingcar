package racingcar.ui;

import java.util.Scanner;

public class InputView {

  private static Scanner SCANNER = new Scanner(System.in);

  private InputView() {
  }

  public static int getIntInput() {
    return SCANNER.nextInt();
  }

  public static void printCountQuestion() {
    System.out.println("자동차 대수는 몇 대 인가요?");
  }

  public static void printTimesQuestion() {
    System.out.println("시도할 회수는 몇회인가요?");
  }
}
