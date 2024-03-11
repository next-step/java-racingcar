package racingcar;

import java.util.List;

public class ResultView {

  public void printGameResult(List<Car> cars) {
    cars.forEach(car -> System.out.println(car.getResult()));
    System.out.println();
  }
}
