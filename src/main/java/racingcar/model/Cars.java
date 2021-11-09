package racingcar.model;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import racingcar.strategy.MovingStrategy;

public class Cars {

  private List<Car> cars;

  public Cars(int numberOfCars) {
    this.cars = Stream.generate(Car::new)
        .limit(numberOfCars)
        .collect(Collectors.toList());
  }

  private Cars() {

  }

  public List<Car> getCars() {
    return cars;
  }

  public void eachMove(MovingStrategy movingStrategy) {
    cars.forEach(car -> car.move(movingStrategy));
  }

}