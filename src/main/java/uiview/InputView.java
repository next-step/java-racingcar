package uiview;

import java.util.Scanner;

public class InputView {

  private static final Scanner scanner = new Scanner(System.in);

  private InputView() {}

  public static int scanInt(String description) {
    printDescription(description);
    return scanner.nextInt();
  }

  public static String scanString(String description) {
    printDescription(description);
    return scanner.next();
  }

  private static void printDescription(String description) {
    System.out.println(description);
  }
}
