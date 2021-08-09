package study.step3.model.car;

import java.util.List;
import java.util.stream.Stream;
import study.step3.model.strategy.MoveStrategy;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class Cars {

  private final List<Car> racingGameCars;

  private Cars(List<Car> cars) {
    this.racingGameCars = cars;
  }

  public static Cars of(List<Car> cars) {
    return new Cars(cars);
  }

  public static Cars of(int carNumber) {
    return Stream.generate(Car::new)
        .limit(carNumber)
        .collect(collectingAndThen(toList(), Cars::of));
  }

  public void move(MoveStrategy moveStrategy) {
    for (Car car : racingGameCars) {
      car.move(moveStrategy);
    }
  }

  public List<Car> getRacingGameCars() {
    return racingGameCars;
  }
}
