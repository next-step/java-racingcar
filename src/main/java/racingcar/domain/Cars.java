package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

  private final List<Car> cars;

  public Cars(Names names) {
    cars = new ArrayList<>();
    names.getNames()
        .forEach(name -> cars.add(new Car(name)));
  }

  public Cars(List<Car> cars) {
    this.cars = new ArrayList<>(cars);
  }

  public int size() {
    return cars.size();
  }

  public Car at(int index) {
    return cars.get(index);
  }

  public void moveAll(RaceEvaluator raceEvaluator) {
    cars.forEach(car -> {
      if (raceEvaluator.evaluate()) {
        car.move();
      }
    });
  }

  public int findMaxScore() {
    return cars.stream()
        .map(Car::getPosition)
        .max(Integer::compare)
        .orElse(0);
  }

  public List<Car> findWinners() {
    int maxScore = findMaxScore();
    return cars.stream()
        .filter(car -> car.isWinner(maxScore))
        .collect(Collectors.toList());
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Cars other = (Cars) o;
    return cars.equals(other.cars);
  }

  @Override
  public int hashCode() {
    return cars.hashCode();
  }
}
