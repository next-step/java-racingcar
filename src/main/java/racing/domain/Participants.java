package racing.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Participants {

  private List<Car> cars;

  public Participants(List<Car> cars) {
    this.cars = cars;
  }

  public static Participants from(List<String> names) {
    return new Participants(names.stream().map(Car::new).collect(Collectors.toList()));
  }

  public List<String> getWinnerNames() {
    return findWinners(findMaxPosition());
  }

  private List<String> findWinners(Position maxPosition) {
    List<String> winners = new ArrayList<>();
    Collections.sort(cars);
    for (Car car : cars) {
      if (car.hasSamePosition(maxPosition)) {
        winners.add(car.getName());
      }
    }
    return winners;
  }

  private Position findMaxPosition() {
    return Collections.max(cars, Comparator.comparing(Car::getPosition)).getPosition();
  }

  public void play(MovementStrategy strategy) {
    for (Car car : cars) {
      car.move(strategy.generate());
    }
  }

  public List<Car> getCars() {
    return this.cars;
  }
}
