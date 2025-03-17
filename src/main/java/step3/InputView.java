package step3;

import java.util.Scanner;

public class InputView {

  private final Scanner scanner;

  public InputView() {
    scanner = new Scanner(System.in);
  }

  public int askInt(String question) {
    System.out.println(question);
    return scanner.nextInt();
  }
}
