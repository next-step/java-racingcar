package racing.view;

import java.util.Scanner;

public class InputView {

  final static Scanner scanner = new Scanner(System.in);

  public static int getValue(String message) {
    System.out.println(message);
    return scanner.nextInt();
  }

}
