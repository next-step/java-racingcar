package view;

import java.util.Scanner;

public class InputView {

  private static final String QUESTION_CAR_COUNT = "자동차 대수는 몇 대 인가요?";
  private static final String QUESTION_TRY_COUNT = "시도할 회수는 몇 회 인가요?";

  public int inputCarCount() {
    printQuestion(QUESTION_CAR_COUNT);
    return new Scanner(System.in).nextInt();
  }

  public int inputTryCount() {
    printQuestion(QUESTION_TRY_COUNT);
    return new Scanner(System.in).nextInt();
  }

  private void printQuestion(String question) {
    System.out.println(question);
  }
}
