package study.step3;

import java.util.Scanner;

public class InputView {

  static final private Scanner SCANNER = new Scanner(System.in);
  static final private String INT_REGEX = "^[0-9]+$";

  private InputView() {
  }

  static int startInput(String question) {
    printQuestion(question);
    return getNumber(input());
  }

  private static void printQuestion(String question) {
    System.out.println(question);
  }

  private static String input() {
    return SCANNER.nextLine();
  }

  private static int getNumber(String number) {
    if (!isPositiveNumber(number)) {
      throw new NumberFormatException("양의 정수가 아닌 값을 입력했습니다.: " + number);
    }
    return Integer.parseInt(number);
  }

  private static boolean isPositiveNumber(String number) {
    return number.matches(INT_REGEX) && Integer.parseInt(number) > 0;
  }

}
