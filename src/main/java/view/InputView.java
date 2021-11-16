package view;

import java.util.Scanner;

public class InputView {

  private static final String QUESTION_CAR_NAMES = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
  private static final String QUESTION_TRY_COUNT = "시도할 회수는 몇 회 인가요?";

  public String[] inputCarNames() {
    printQuestion(QUESTION_CAR_NAMES);
    return new Scanner(System.in).next().split(",");
  }

  public int inputTryCount() {
    printQuestion(QUESTION_TRY_COUNT);
    return new Scanner(System.in).nextInt();
  }

  private void printQuestion(String question) {
    System.out.println(question);
  }
}
