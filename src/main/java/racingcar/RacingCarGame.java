package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingCarGame {

  private static final int RANDOM_BOUND = 10;
  private static final int MOVE_CONDITION = 4;

  private List<Car> cars;

  public RacingCarGame() {
    this.cars = new ArrayList<>();
  }

  public List<Car> createCars(int carCount) {
    if (carCount <= 0) {
      throw new IllegalArgumentException("please set carCount and tryCount greater than 0");
    }

    for (int i = 0; i < carCount; i++) {
      cars.add(new Car());
    }
    return cars;
  }

  public List<Car> racing(int tryCount) {

    if (tryCount <= 0) {
      throw new IllegalArgumentException("please set carCount and tryCount greater than 0");
    }

    for (Car car : cars) {
      if (moveCondition()) {
        car.move();
      }
    }
    return cars;
  }

  private boolean moveCondition() {
    Random random = new Random();
    return random.nextInt(RANDOM_BOUND) >= MOVE_CONDITION;
  }
}
