package carracing;

import java.util.Scanner;

public class InputView {
  private final Scanner scanner;

  public InputView(Scanner scanner) {
    this.scanner = scanner;
  }

  public int receiveCarCount() {
    System.out.println("자동차 대수는 몇 대 인가요?");
    return getIntegerInput();
  }

  public int receiveTryCount() {
    System.out.println("시도할 회수는 몇 회 인가요?");
    return getIntegerInput();
  }

  private int getIntegerInput() {
    int count = scanner.nextInt();
    scanner.nextLine();
    return count;
  }
}