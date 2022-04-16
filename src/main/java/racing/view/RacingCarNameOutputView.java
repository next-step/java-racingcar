package racing.view;

import racing.domain.NamedCar;
import racing.domain.NamedCars;

public class RacingCarNameOutputView {

  public static final String DISTANCE = "-";
  public static final String EMPTY = "";
  public static final String CAR_NAME_DELIMITER = ", ";

  public void printResultTitle() {
    System.out.println("실행 결과");
  }

  public void printCarNameAndDistance(NamedCars cars) {
    for (NamedCar car : cars.getNamedCars()) {
      System.out.print(car.getCarName() + " : " + DISTANCE.repeat(car.getDistance()));
      System.out.println(EMPTY);
    }
    System.out.println(EMPTY);
  }

  public void printWinner(NamedCars cars) {
    StringBuilder winnerSb = new StringBuilder();
    for (String name : cars.getNames()) {
      winnerSb.append(name + CAR_NAME_DELIMITER);
    }
    winnerSb.delete(winnerSb.length() - 2, winnerSb.length());
    System.out.println(winnerSb.toString() + "가 최종 우승했습니다");
  }

}
