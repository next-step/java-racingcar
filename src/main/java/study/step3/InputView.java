package study.step3;

import java.util.Scanner;

public class InputView {

  static final private Scanner SCANNER = new Scanner(System.in);

  private InputView() {
  }

  static int startInput(String question) {
    printQuestion(question);
    return inputNumber();
  }

  private static void printQuestion(String question) {
    System.out.println(question);
  }

  private static int inputNumber() {
    String number = SCANNER.nextLine();
    if (!isPositiveNumber(number)) {
      throw new NumberFormatException("양의 정수가 아닌 값을 입력했습니다.: " + number);
    }
    return Integer.parseInt(number);
  }

  private static boolean isPositiveNumber(String number) {
    return number.matches("[0-9]+") && Integer.parseInt(number) > 0;
  }

}
