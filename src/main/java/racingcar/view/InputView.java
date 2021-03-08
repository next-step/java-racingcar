package racingcar.view;

import java.util.Scanner;

public class InputView {

  public static int inputCount(String message) {
    System.out.println(message);
    return new Scanner(System.in).nextInt();
  }
}
