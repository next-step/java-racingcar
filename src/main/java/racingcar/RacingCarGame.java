package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RacingCarGame {

  private List<Car> cars;

  public RacingCarGame() {
    this.cars = new ArrayList<>();
  }

  public List<Car> createCars(int carCount) {
    if (carCount <= 0) {
      throw new IllegalArgumentException("please set carCount and tryCount greater than 0");
    }

    cars = Stream.generate(Car::new)
        .limit(carCount)
        .collect(Collectors.toList());

   return cars;
  }

  public List<Car> racing(int tryCount, MoveCondition moveCondition) {

    if (tryCount <= 0) {
      throw new IllegalArgumentException("please set carCount and tryCount greater than 0");
    }

    cars.stream()
        .filter(car -> moveCondition.isMovable())
        .forEach(Car::move);

    return cars;
  }
}
