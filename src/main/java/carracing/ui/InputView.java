package carracing.ui;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {

  private Scanner scanner = new Scanner(System.in);

  private static final String CAR_QUESTION = "자동차 대수는 몇대 인가요?";
  private static final String TRY_QUESTION = "시도할 횟수는 몇 회 인가요?";
  private static final String INPUT_MESSAGE = "잘못 입력 하셨습니다. 0 이상의 자연수를 입력해주세요";

  private static final int ZERO = 0;
  private static final int INIT_COUNT_NUMBER = -1;

  public int inputNumberOfCar() {
    return inputOperation(CAR_QUESTION);
  }

  public int inputTryCount() {
    return inputOperation(TRY_QUESTION);
  }

  private int inputOperation(String question) {
    int count = INIT_COUNT_NUMBER;
    while (count < ZERO) {
      System.out.println(question);
      try {
        count = scanner.nextInt();
      } catch (InputMismatchException e) {
        System.out.println(INPUT_MESSAGE);
      }
      if (count < 0) {
        System.out.println(INPUT_MESSAGE);
      }
    }
    return count;
  }
}
