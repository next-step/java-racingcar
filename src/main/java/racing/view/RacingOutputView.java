package racing.view;

import java.util.List;
import racing.object.Car;

public class RacingOutputView {

  public static final String DISTANCE = "-";
  public static final String EMPTY = "";

  public void printCarDistance(List<Car> cars) {
    for (Car car : cars) {
      for (int i = 0; i < car.getDistance(); i++) {
        System.out.print(DISTANCE);
      }
      System.out.println(EMPTY);
    }
    System.out.println(EMPTY);
  }

  public void printResultTitle() {
    System.out.println("실행 결과");
  }
}
