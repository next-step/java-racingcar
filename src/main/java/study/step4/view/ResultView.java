package study.step4.view;

import study.step4.model.car.Car;
import study.step4.model.car.Cars;
import study.step4.model.view.Result;

public class ResultView {

  private static final String DISTANCE_SEPERATOR = "-";

  Result result;

  public ResultView(Cars cars) {
    result = new Result(cars);
  }

  public void printResult() {
    for (Car car : result.getRacingGameCars()) {
      printCarDistance(car);
    }
    System.out.println();
  }

  public void printCarDistance(Car car) {

    System.out.print(car.getName() + " : ");

    for (int i = 0; i < car.getDistance(); i++) {
      System.out.print(DISTANCE_SEPERATOR);
    }
    System.out.println();
  }

  public Result getResult() {
    return result;
  }
}
