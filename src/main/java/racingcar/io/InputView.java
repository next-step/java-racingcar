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
}
