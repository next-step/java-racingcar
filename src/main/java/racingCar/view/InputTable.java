package racingCar.view;

import java.util.Scanner;

public final class InputTable {

  private final static Scanner SCANNER = new Scanner(System.in);

  private InputTable() {
  }

  public static Integer howManyCar() {
    return SCANNER.nextInt();
  }

  public static String insertCarNames() {
    return SCANNER.next();
  }

  public static Integer howManyGame() {
    return SCANNER.nextInt();
  }
}