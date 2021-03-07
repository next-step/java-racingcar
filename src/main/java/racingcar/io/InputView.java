package racingcar.io;

import java.util.Scanner;

public class InputView implements AutoCloseable {

  private final Scanner scanner;
  private boolean closed;

  public InputView(Scanner scanner) {
    this.scanner = scanner;
  }

  @Override
  public void close() {
    if (closed) {
      return;
    }
    scanner.close();
    closed = true;
  }

  public int inputCarCount() {
    return input("자동차 대수", "대");
  }

  public int inputRound() {
    return input("시도할 회수", "회");
  }

  private boolean isPositive(int number) {
    return number > 0;
  }

  private int input(String message, String unit) {
    System.out.println(message + "는 몇 " + unit + " 인가요?");
    Printer.printPrompt();

    int carCount = scanner.nextInt();
    if (isPositive(carCount)) {
      return carCount;
    }
    throw new IllegalArgumentException(message + "는 양수여야 합니다.");
  }

}
