package racingcar.view;

import java.util.Scanner;

public class InputView {
  public static String getInput(String message) {
    System.out.println(message);
    return (new Scanner(System.in)).nextLine();
  }
}
