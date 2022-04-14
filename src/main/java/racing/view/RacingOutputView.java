package racing.view;

import racing.domain.Cars;

public class RacingOutputView {

  public static final String DISTANCE = "-";
  public static final String EMPTY = "";

  public void printResultTitle() {
    System.out.println("실행 결과");
  }

  public void printCarDistance(Cars cars) {
    for (int distance : cars.getDistances()) {
      System.out.print(DISTANCE.repeat(distance));
      System.out.println(EMPTY);
    }
    System.out.println(EMPTY);
  }
}
