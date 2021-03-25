package step5.model;

import step5.strategy.Strategy;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {
  private final List<Car> cars;

  public Cars(List<Car> cars) {
    this.cars = cars;
  }

  public List<Car> getCars() {
    return cars;
  }

  public boolean runCycle(Strategy strategy) {
    cars.forEach(car -> car.move(strategy));
    return true;
  }

  public List<Car> findWinners() {
    return findWinners(getMaxPosition());
  }

  private List<Car> findWinners(Position maxPosition) {
    List<Car> winners = cars.stream().filter(car -> car.isWinner(maxPosition)).collect(Collectors.toList());
    return winners;
  }

  private Position getMaxPosition() {
    Position maxPosition = new Position();
    for (Car car : cars) {
      maxPosition = car.getMaxPosition(maxPosition);
    }
    return maxPosition;
  }
}