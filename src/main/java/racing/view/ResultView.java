package racing.view;

import java.util.List;
import java.util.stream.IntStream;
import racing.Car;

public class ResultView {

  public void printMoveResult(List<Car> cars) {
    cars.forEach(this::printCarPosition);
    System.out.print("\n");
  }

  private void printCarPosition(Car car) {

    IntStream
        .range(0, car.getPosition())
        .forEach(index -> System.out.print("-"));
    System.out.print("\n");
  }
}
