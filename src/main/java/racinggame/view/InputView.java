package racinggame.view;

import java.util.Scanner;

public class InputView {
  private static final Scanner scanner = new Scanner(System.in);

  public static int inputTime() {
    System.out.println("시도할 회수는 몇 회 인가요?");
    return validateNumber(scanner.nextLine());
  }

  public static String inputName() {
    System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
    return validateString(scanner.nextLine());
  }

  private static int validateNumber(String number) {
    try {
      return Integer.parseInt(number);
    } catch (NumberFormatException ex) {
      throw new IllegalArgumentException("숫자 형태가 아닙니다. input value : " + number);
    }
  }

  private static String validateString(String name) {
    if (name.isEmpty()) {
      throw new IllegalArgumentException("이름을 입력해야 합니다.");
    }
    return name;
  }
}