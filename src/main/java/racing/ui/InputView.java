package racing.ui;

import java.util.Scanner;

public class InputView {

  private final Scanner scanner;

  public InputView() {
    this.scanner = new Scanner(System.in);
  }

  public int input(Message message) {
    System.out.println(message.getMessage());
    while (true) {
      try {
        int value = scanner.nextInt();
        return value;
      } catch (Exception e) {
        System.out.println("올바른 숫자를 입력해주세요:");
        scanner.nextLine();
      }
    }
  }

  public void close() {
    scanner.close();
  }
}