package study.step4.view;

import java.util.List;
import study.step4.model.car.Car;
import study.step4.model.car.Cars;

public class ResultView {

  private static final String DISTANCE_SEPERATOR = "-";
  private static final String CAR_NAME_SPLITER = ",";

  public void printGameResult(Cars cars) {
    for (int i = 0; i < cars.getRacingGameCarsCount(); i++) {
      printResult(cars.getCar(i).getName(), cars.getCar(i).getDistance());
    }
    System.out.println();
  }

  private void printResult(String carName, int carDistance) {
    System.out.print(carName + " : ");
    for (int i = 0; i < carDistance; i++) {
      System.out.print(DISTANCE_SEPERATOR);
    }
    System.out.println();
  }

  public void printWinner(List<Car> cars) {
    StringBuilder stringBuilder = new StringBuilder();

    for (Car car : cars) {
      stringBuilder.append(car.getName());
      stringBuilder.append(CAR_NAME_SPLITER);
    }
    stringBuilder.deleteCharAt(stringBuilder.lastIndexOf(CAR_NAME_SPLITER));
    stringBuilder.append("가 최종 우승했습니다.");
    System.out.println(stringBuilder);
  }
}
