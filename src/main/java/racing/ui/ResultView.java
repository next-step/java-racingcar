package racing.ui;

import java.util.List;
import racing.domain.Car;

public class ResultView {

  private static final String POSITION_MARKER = "-";

  public void printStart() {
    System.out.println("\n" + Message.RESULT_MESSAGE.getMessage());
  }

  public void printRoundResult(List<Car> cars) {
    for (Car car : cars) {
      System.out.println(POSITION_MARKER.repeat(car.getPosition()));
    }
    System.out.println();
  }
}
