package racing.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 참가자 관리, 우승자 판별
 * */
public class Participants {

  private final List<Car> cars;

  public Participants(List<Car> cars) {
    this.cars = cars;
  }

  public static Participants from(List<String> names) {
    return new Participants(names.stream().map(Car::new).toList());
  }

  public List<String> getWinnerNames() {
    return findWinners(findMaxPositionCar());
  }

  public void play(MovementStrategy strategy) {
    for (Car car : cars) {
      car.move(strategy.generate());
    }
  }

  @Override
  public String toString() {
    String str = "";
    for(Car car : this.cars) {
      str += car.toString() + '\n';
    }
    return str;
  }

  private List<String> findWinners(Car maxPositionCar) {
    List<String> winners = new ArrayList<>();
    for (Car car : cars) {
      if (car.hasSamePosition(maxPositionCar)) {
        winners.add(car.getName());
      }
    }
    return winners;
  }

  private Car findMaxPositionCar() {
    return Collections.max(cars);
  }
}
