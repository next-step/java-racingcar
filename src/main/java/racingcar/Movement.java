package racingcar;

import java.util.List;
import racingcar.model.Car;
import racingcar.util.RandomGenerator;

public class Movement {

  private static final int MOVE_CONDITION = 4;
  private static final int RANDOM_RANGE = 10;

  public void moveCars(List<Car> cars) {
    cars.forEach(car -> moveOrNot(car));
  }

  public boolean isMoveable(int number) {
    return number >= MOVE_CONDITION;
  }

  private void moveOrNot(Car car) {
    if (isMoveable(RandomGenerator.generateRandomNumber(RANDOM_RANGE))) {
      car.move();
    }
  }

  public static String trackingMovement(Car car, String track) {
    StringBuilder movement = new StringBuilder();
    for (int i = 0; i < car.getLocation(); i++) {
      movement.append(track);
    }
    return movement.toString();
  }
}
