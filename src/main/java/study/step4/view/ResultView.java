package study.step4.view;

import study.step4.model.car.Car;
import study.step4.model.car.Cars;
import study.step4.model.view.Result;

public class ResultView {

  private static final String DISTANCE_SEPERATOR = "-";
  private static final String CAR_NAME_SPLITER = ",";

  Result result;

  public ResultView(Cars cars) {
    result = new Result(cars);
  }

  public void printResult() {
    for (Car car : result.getRacingGameCars()) {
      printCarDistance(car);
    }
    System.out.println();

    result.updateWinnerDistance();
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

  public void printWinner() {

    StringBuilder stringBuilder = new StringBuilder();

    for (Car car : result.getRacingGameCars()) {
      setPrintString(stringBuilder, car);
    }

    stringBuilder.deleteCharAt(stringBuilder.lastIndexOf(CAR_NAME_SPLITER));
    stringBuilder.append("가 최종 우승했습니다.");

    System.out.println(stringBuilder);
  }

  private void setPrintString(StringBuilder stringBuilder, Car car) {
    if (car.getDistance() == result.getCarWinnerDistance()) {
      stringBuilder.append(car.getName());
      stringBuilder.append(CAR_NAME_SPLITER);
    }
  }
}
