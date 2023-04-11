package study.racinggame.view;

import java.util.Scanner;

import static study.racinggame.util.NumberValidator.validatedPositive;

public class InputView {

  private static final Scanner scanner = new Scanner(System.in);
  private static final String carMessage = "자동차 대수는 몇 대 인가요?";
  private static final String tryMessage = "시도할 횟수는 몇 회 인가요?";

  public static int inputCarNumber() {
    System.out.println(carMessage);
    return validatedPositive(scanner.nextInt());
  }

  public static int inputTryNumber() {
    System.out.println(tryMessage);
    return validatedPositive(scanner.nextInt());
  }
}
