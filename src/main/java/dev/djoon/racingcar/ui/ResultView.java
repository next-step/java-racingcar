package dev.djoon.racingcar.ui;

import dev.djoon.racingcar.actor.Car;
import java.util.List;
import java.util.StringJoiner;

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
    System.out.print("-"); /** 기본 출발선(=0) **/
    for (int i = 0; i < xPos; i++) {
      System.out.print("-");
    }
    System.out.println();
  }

  public static void printCR() {
    System.out.println();
  }

  public static String getWinnerNames(List<Car> cars) {
    StringJoiner stringJoiner = new StringJoiner(", ");
    for (Car car : cars) {
      stringJoiner.add(car.getOwner());
    }

    return stringJoiner.toString();
  }

  public static void printWinner(List<Car> cars) {
    System.out.println(getWinnerNames(cars) + "가 최종 우승했습니다.");
  }
}
