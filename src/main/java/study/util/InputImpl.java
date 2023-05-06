package study.util;

import java.util.Scanner;

public class InputImpl implements Input {

  @Override
  public String getInput(String answer) {
    Scanner scanner = new Scanner(System.in);

    System.out.println(answer);
    return scanner.nextLine();
  }
}
