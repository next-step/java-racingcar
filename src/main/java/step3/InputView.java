package step3;

import java.util.Scanner;

public class InputView {

  public static final String NUMBER_OF_ATTEMPTS_MESSAGE = "시도할 회수는 몇 회 인가요?";
  private static final String NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분.";

  private Input input;

  public void render() {
    final Scanner scanner = new Scanner(System.in);
    print(NAMES_MESSAGE);
    final String names = scanner.nextLine();
    print(NUMBER_OF_ATTEMPTS_MESSAGE);
    final int numberOfAttempts = scanner.nextInt();

    input = new Input(names, numberOfAttempts);
    scanner.close();
  }

  private void print(String message) {
    System.out.println(message);
  }

  public Input getInput() {
    if (input == null) {
      throw new IllegalStateException("입력 된 값이 없습니다.");
    }
    return input;
  }
}
