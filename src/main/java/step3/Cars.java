package step3;

import step3.view.ResultView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Cars {
  private List<Car> cars;
  private MoveStrategy moveStrategy;

  private Cars (List<Car> cars, MoveStrategy moveStrategy) {
    this.cars = cars;
    this.moveStrategy = moveStrategy;
  }

  public Stream<Car> move () {
    this.cars.stream()
             .filter(car -> moveStrategy.isMoved())
             .forEach(car -> car.move());
    return this.stream();
  }

  public Stream<Car> stream () {
    return this.cars.stream();
  }

  public static Cars of (int carCount, MoveStrategy moveStrategy) {
    return new Cars(
      Arrays.stream(new int[carCount])
        .mapToObj(v -> Car.of())
        .collect(Collectors.toList()),
      moveStrategy
    );
  }

  public static Cars of (List<Car> cars, MoveStrategy moveStrategy) {
    return new Cars(cars, moveStrategy);
  }

}
