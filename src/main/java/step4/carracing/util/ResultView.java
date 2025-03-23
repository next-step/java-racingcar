package step4.carracing.util;

import step4.carracing.domain.Car;
import step4.carracing.domain.Cars;

import java.util.stream.Collectors;

public class ResultView {
  public static void printAllCarStatus(Cars cars) {
    for (Car car : cars) {
      System.out.println(car);
    }
    System.out.println();
  }

  public static void printWinners(Cars winners) {
    String winnersResult = winners.stream()
            .map(Car::getName)
            .collect(Collectors.joining(", "));
    System.out.println(winnersResult + "가 최종 우승했습니다.");
  }
}
