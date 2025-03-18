package racing.view;

import java.util.List;
import racing.domain.Car;

public class ResultView {

  public static void printRaceResult(List<Car> cars) {
    for (Car car : cars) {
      System.out.println("-".repeat(car.getPosition()));
    }
    System.out.println();
  }
}
