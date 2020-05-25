package step3;

import java.util.Scanner;

public class RacingGameInput {
  private static Scanner scanner = new Scanner(System.in);

  public static int getNumberOfCarsByScanner() {
    RacingGameInputView.printNumberOfCarsInputMessage();

    return scanner.nextInt();
  }

  public static int getTimeByScanner() {
    RacingGameInputView.printTimeInputMessage();

    return scanner.nextInt();
  }
}
