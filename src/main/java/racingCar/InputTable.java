package racingCar;

import java.util.Scanner;

public final class InputTable {
  final static Track TRACK = new Track();
  private final static Scanner SCANNER = new Scanner(System.in);
  private InputTable() {
  }

  public static void howManyCar() {
    System.out.println("자동차 대수는 몇 대 인가요? ");
    TRACK.addCar(SCANNER.nextInt());
  }

  public static void howManyGame() {
    System.out.println("시도할 회수는 몇 회 인가요? ");
    TRACK.setGameCount(SCANNER.nextInt());
  }

}
