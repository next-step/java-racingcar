package study.racing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Cars {

  List<Car> cars = new ArrayList<>();
  MoveStrategy strategy;

  public Cars() { this.strategy = new NumberConditionMoveStrategy(); }

  public Cars(MoveStrategy strategy) {
    this.strategy = strategy;
  }

  public void addAll(Car... cars) {
    this.cars.addAll(Arrays.asList(cars));
  }

  public void moveByStrategy() {
    for (Car car : cars) {
      car.move(strategy);
    }
  }

  public void printPosition() {
    for (Car car : cars) {
      ResultView.printPosition(car.getPosition());
    }
  }

  public int getSize() {
    return cars.size();
  }
}
