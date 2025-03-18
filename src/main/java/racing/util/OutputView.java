package racing.util;

import racing.simulator.RacingCar;

import java.util.List;

public class OutputView {

  public static void showExecutionResultText() {
    System.out.println("실행 결과");
  }

  public static void showLocation(List<RacingCar> racingCars) {
    racingCars.forEach(racingCar -> {
      String name = racingCar.getName();

      String output = (name == null)
          ? "-".repeat(Math.max(0, racingCar.getLocation()))
          : name + " : " + "-".repeat(Math.max(0, racingCar.getLocation()));

      System.out.println(output);
    });
  }

  public static void showWhitespace() {
    System.out.println();
  }
}
