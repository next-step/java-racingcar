package study.step3.view;

import java.util.Scanner;

public class InputView {

  static final private Scanner SCANNER = new Scanner(System.in);
  static final private String QUESTION_NUM_OF_CARS = "자동차 대수는 몇 대 인가요?";
  static final private String QUESTION_NUM_OF_ROUNDS = "시도할 회수는 몇 회 인가요?";

  private InputView() {
  }

  public static int inputNumOfCars() {
    printQuestion(QUESTION_NUM_OF_CARS);
    return intputNum();
  }

  public static int inputNumOfRaces() {
    printQuestion(QUESTION_NUM_OF_ROUNDS);
    return intputNum();
  }

  private static void printQuestion(String question) {
    System.out.println(question);
  }

  private static int intputNum() {
    int number = SCANNER.nextInt();
    if (number <= 0) {
      throw new NumberFormatException("양의 정수가 아닌 값을 입력했습니다.: " + number);
    }
    return number;
  }
}
