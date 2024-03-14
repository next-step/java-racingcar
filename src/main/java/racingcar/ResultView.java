package racingcar;

import java.util.List;

public class ResultView {

  public void printGameResult(List<Car> cars) {
    cars.forEach(car -> System.out.println("-".repeat(car.getPosition())));
    System.out.println();
  }
}
