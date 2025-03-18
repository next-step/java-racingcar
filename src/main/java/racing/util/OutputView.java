package racing.util;

import racing.types.Car;
import racing.types.CarName;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

  public static void showExecutionResultText() {
    System.out.println("실행 결과");
  }

  public static void showLocation(List<Car> cars) {
    cars.forEach(racingCar -> {
      String name = racingCar.getName();

      String output = (CarName.DEFAULT_NAME.equals(name))
          ? "-".repeat(Math.max(0, racingCar.getLocation()))
          : name + " : " + "-".repeat(Math.max(0, racingCar.getLocation()));

      System.out.println(output);
    });
  }

  public static void showWinner(List<Car> winners) {
    String winnerNames = winners.stream()
        .map(Car::getName)
        .collect(Collectors.joining(", "));

    System.out.println(winnerNames + " 가 최종 우승했습니다.");
  }

  public static void showWhitespace() {
    System.out.println();
  }
}
