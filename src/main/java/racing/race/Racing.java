package racing.race;

import java.util.List;
import racing.view.OutputView;

public class Racing {

  public void race(List<Car> cars, int tryNumber) {
    if (tryNumber < 0) {
      throw new NumberFormatException();
    }
    for (int i = 0; i < tryNumber; i++) {
      tryMove(cars);
      OutputView.print();
    }
  }

  private static void tryMove(List<Car> cars) {
    for (Car car : cars) {
      car.move();
      OutputView.printNumberToDash(car.moveDistance());
    }
  }

}
