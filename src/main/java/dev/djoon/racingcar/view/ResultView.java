package dev.djoon.racingcar.view;

import dev.djoon.racingcar.domain.Car;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {
  public static void printNewGame() {
    System.out.println("실행 결과");
  }

  public static void printCarriageReturn() {
    System.out.println();
  }

  public static void printRoundResult(List<Car> cars) {
    cars.stream().map(Car::getPositionRepresentation)
                 .forEachOrdered(System.out::println);

    printCarriageReturn();
  }

  public static String getWinnerNames(List<Car> cars) {
    return cars.stream()
               .map(Car::getOwner)
               .collect(Collectors.joining(", "));
  }

  public static void printWinner(List<Car> cars) {
    System.out.println(getWinnerNames(cars) + "가 최종 우승했습니다.");
  }
}
