package racingCar.view;

import java.util.List;
import java.util.Scanner;

public final class InputTable {


  private final static Scanner SCANNER = new Scanner(System.in);

  private InputTable() {
  }

  public static Integer howManyCar() {
    return SCANNER.nextInt();
  }

  public static Integer howManyGame() {
    return SCANNER.nextInt();
  }
}