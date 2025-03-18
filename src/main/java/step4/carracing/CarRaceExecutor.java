package step4.carracing;

import java.util.Scanner;

public class CarRaceExecutor {

  public static void main(String[] args) {
    CarRaceGame carRace = new CarRaceGame(new RandomCarMoveStrategy(), new Scanner(System.in));
    carRace.start();
  }
}
