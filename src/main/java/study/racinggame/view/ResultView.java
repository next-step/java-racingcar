package study.racinggame.view;

import study.racinggame.domain.Car;
import study.racinggame.domain.Cars;
import study.racinggame.domain.GameResult;

public class ResultView {

  private ResultView() {}

  public static void show(GameResult result) {
    System.out.println();
    System.out.println("실행 결과");

    for (Cars cars : result.record()) {
     printDistance(cars);

     System.out.println();
    }
  }

  private static void printDistance(Cars cars) {
    cars.cars().forEach((car) -> System.out.println(car.printedDistance()));
  }
}
