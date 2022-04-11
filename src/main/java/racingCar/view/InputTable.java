package racingCar.view;

import java.util.Scanner;

public final class InputTable {

  private final static Scanner SCANNER = new Scanner(System.in);

  private InputTable() {
  }

  public static String insertName() {
    return SCANNER.next();
  }

  public static Integer howManyGame() {
    return SCANNER.nextInt();
  }
}