package study.input;

import java.util.Scanner;

public class InputImpl implements Input {

  @Override
  public int getInput(String answer) {
    Scanner scanner = new Scanner(System.in);

    System.out.println(answer);
    String value = scanner.nextLine();
    return Integer.parseInt(value);
  }
}
