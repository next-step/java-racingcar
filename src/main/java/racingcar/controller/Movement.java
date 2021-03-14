package racingcar.controller;

import java.util.List;
import racingcar.model.Car;
import racingcar.model.Position;
import racingcar.util.RandomGenerator;

public class Movement {

  private static final int MOVE_CONDITION = 4;
  private static final int RANDOM_RANGE = 10;

  public void moveCars(List<Car> cars) {
    cars.forEach(car -> moveOrNot(car.getPosition()));
  }

  public boolean isMoveable(int number) {
    return number >= MOVE_CONDITION;
  }

  private void moveOrNot(Position position) {
    if (isMoveable(RandomGenerator.generateRandomNumber(RANDOM_RANGE))) {
      position.move();
    }
  }

  public static String trackingMovement(Position position, String track) {
    StringBuilder movement = new StringBuilder();
    for (int i = 0; i < position.getPosition(); i++) {
      movement.append(track);
    }
    return movement.toString();
  }
}
