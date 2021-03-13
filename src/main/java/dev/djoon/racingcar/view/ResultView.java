package dev.djoon.racingcar.view;

import dev.djoon.racingcar.domain.Car;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {
  public static void printNewGame() {
    System.out.println("실행 결과");
  }

  public static void printCarOwner(Car car) {
    if ("".equals(car.getOwner())) {
      return;
    }

    System.out.print(car.getOwner() + " : ");
  }

  public static void printXPos(int xPos) {
    for (int i = 0; i < xPos; i++) {
      System.out.print("-");
    }
    System.out.println();
  }

  public static void printCR() {
    System.out.println();
  }

  public static void printRoundResult(List<Car> cars) {
    for (Car car : cars) {
      printCarOwner(car);
      printXPos(car.getXPosition());
    }
    printCR();
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
