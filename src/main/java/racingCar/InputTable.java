package racingCar;

import java.util.Scanner;

public final class InputTable {
  final static Track TRACK = new Track();
  private final static Scanner SCANNER = new Scanner(System.in);
  private final static String HOW_MANY_CARS = "자동차 대수는 몇 대 인가요?";
  private final static String HOW_MANY_GAMES = "자동차 대수는 몇 대 인가요?";

  private InputTable() {
  }
  public static void howManyCar() {
    System.out.println(HOW_MANY_CARS);
    TRACK.addCar(SCANNER.nextInt());
  }
  public static void howManyGame() {
    System.out.println(HOW_MANY_GAMES);
    TRACK.setGameCount(SCANNER.nextInt());
  }
}