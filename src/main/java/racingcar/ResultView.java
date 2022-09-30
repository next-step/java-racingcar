package racingcar;

import racingcar.domain.Car;

import java.util.List;

public class ResultView {

  private static final String positionPoint = "-";

  public void printResult(List<Car> cars) {
    for (Car car : cars) {
      for (int j = 0; j < car.getPosition(); j++) {
        System.out.print(positionPoint);
      }
      System.out.println("");
    }
    System.out.println();
  }

}
