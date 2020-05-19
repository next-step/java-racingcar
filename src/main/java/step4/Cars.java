package step4;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Cars {
  private List<Car> cars;

  private Cars(List<Car> cars) {
    this.cars = cars;
  }

  public Cars move (MoveStrategy moveStrategy) {
    this.cars.stream()
             .filter(car -> moveStrategy.isMoved())
             .forEach(car -> car.move());
    return this;
  }

  public Stream<Car> stream () {
    return this.cars.stream();
  }

  public static Cars of (String[] cars) {
    return new Cars(
      Arrays.stream(cars)
            .map(Car::of)
            .collect(Collectors.toList())
    );
  }

  public static Cars of (List<Car> cars) {
    return new Cars(cars);
  }

}
