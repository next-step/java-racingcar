package racing.view;

import java.util.Scanner;

public class InputView {

  final static Scanner scanner = new Scanner(System.in);

  public static String getStringValue() {
    return scanner.nextLine();
  }

  public static int getIntValue() {
    return scanner.nextInt();
  }

}
