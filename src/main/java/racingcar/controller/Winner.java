package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;
import racingcar.model.Position;

public class Winner {

  public List<Car> nameOfWinner = new ArrayList<>();

  public int getMaxPosition(List<Car> cars) {
    int maxPosition = 0;
    for (Car car : cars) {
      maxPosition = comparePosition(car.getPosition(), maxPosition);
    }
    return maxPosition;
  }

  private int comparePosition(Position position, int maxPosition) {
    return Math.max(position.getPosition(), maxPosition);
  }

  public boolean isWinner(Position position, int maxPosition) {
    return position.getPosition() == maxPosition;
  }

  private void addWinner(Car car, int maxLocation) {
    if (isWinner(car.getPosition(), maxLocation)) {
      nameOfWinner.add(car);
    }
  }

  public void decideWinner(List<Car> cars) {
    int maxPosition = getMaxPosition(cars);
    cars.forEach(car -> addWinner(car, maxPosition));
  }
}
