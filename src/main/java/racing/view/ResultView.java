package racing.view;

import java.util.List;
import racing.Car;

public class ResultView {

  public void printMoveResult(List<Car> cars) {
    cars.forEach(this::printCarPosition);
    System.out.print("\n");
  }

  private void printCarPosition(Car car) {

    int position = car.getPosition();
    for(int index = 0; index < position; index++) {
      System.out.print("-");
    }
    System.out.print("\n");
  }
}
