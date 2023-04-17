package study.racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Race {

  private static final int FIRST_INDEX = 0;

  private List<Car> cars;

  public Race(List<Car> cars) {
    this.cars = cars;
  }

  public void play() {
    for (Car car : cars) {
      car.move();
    }
  }

  public List<Car> getCars() {
    return cars;
  }

  public List<String> getWinners() {
    return getWinnerNames(sortCars());
  }

  private List<Car> sortCars() {
    List<Car> sortedCars = new ArrayList<>(this.getCars());
    Collections.sort(sortedCars, (car1, car2) -> {
      return car2.getDistance() - car1.getDistance();
    });
    return sortedCars;
  }

  private List<String> getWinnerNames(List<Car> sortedCars) {
    List<String> winnerNames = new ArrayList<>();
    for (Car car : sortedCars) {
      if (!car.isWinner(sortedCars.get(FIRST_INDEX))) {
        break;
      }
      winnerNames.add(car.getName());
    }
    return winnerNames;
  }
}
