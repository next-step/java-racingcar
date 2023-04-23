package study.racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import study.racingcar.factory.RandomIntFactory;

public class Race {

  private List<Car> cars;

  public Race(List<Car> cars) {
    this.cars = cars;
  }

  public void play(RandomIntFactory randomIntFactory) {
    for (Car car : this.cars) {
      car.move(randomIntFactory.createRandomInt());
    }
  }

  public List<Car> findWinner() {
    return findWinners(getMaxPosition());
  }

  private Position getMaxPosition() {
    Position maxPosition = new Position(0);
    for (Car car : this.cars) {
      maxPosition = car.getMaxPosition(maxPosition);
    }
    return maxPosition;
  }

  private List<Car> findWinners(Position maxPosition) {
    List<Car> winners = new ArrayList<>();
    for (Car car : this.cars) {
      if (car.isSamePosition(maxPosition)) {
        winners.add(car);
      }
    }
    return winners;
  }

  public List<Car> getCars() {
    return cars;
  }
}
