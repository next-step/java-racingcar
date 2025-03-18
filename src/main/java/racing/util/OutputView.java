package racing.util;

import racing.types.RacingCar;
import racing.types.RacingCarName;

import java.util.List;

public class OutputView {

  public static void showExecutionResultText() {
    System.out.println("실행 결과");
  }

  public static void showLocation(List<RacingCar> racingCars) {
    racingCars.forEach(racingCar -> {
      String name = racingCar.getName();

      String output = (RacingCarName.DEFAULT_NAME.equals(name))
          ? "-".repeat(Math.max(0, racingCar.getLocation()))
          : name + " : " + "-".repeat(Math.max(0, racingCar.getLocation()));

      System.out.println(output);
    });
  }

  public static void showWhitespace() {
    System.out.println();
  }
}
