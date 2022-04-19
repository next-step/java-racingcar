package uiview;

import java.util.Scanner;

public class InputView {

  private final Scanner scanner;

  public InputView() {
    this.scanner = new Scanner(System.in);
  }

  public int scanInt(String description) {
    System.out.println(description);
    return scanner.nextInt();
  }
}
