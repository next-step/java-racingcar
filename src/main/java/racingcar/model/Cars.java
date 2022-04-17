package racingcar.model;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class Cars {

  private final List<Car> values;

  public Cars(List<Car> cars) {
    validateSameNames(cars);
    this.values = cars;
  }

  public static Cars createCars(List<String> carNames, int startPosition) {
    List<Car> cars = carNames.stream()
        .map(name -> new Car(name, startPosition))
        .collect(Collectors.toList());
    return new Cars(cars);
  }

  public void move(MovingStrategy movingStrategy) {
    values.forEach(car -> car.moveOrStop(movingStrategy));
  }

  public List<Car> findWinners() {
    Car winnerCar = values.stream()
        .max(Car::compareTo)
        .orElseThrow(IllegalStateException::new);
    return values.stream()
        .filter(car -> car.hasSamePosition(winnerCar))
        .collect(Collectors.toList());
  }

  public int size() {
    return values.size();
  }

  public List<Car> getValues() {
    return values;
  }

  private void validateSameNames(List<Car> values) {
    Set<String> carNameSet = values.stream()
        .map(Car::getName)
        .collect(Collectors.toSet());
    if (carNameSet.size() != values.size()) {
      throw new IllegalArgumentException("자동차 이름은 중복될 수 없습니다.");
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Cars cars = (Cars) o;
    return Objects.equals(values, cars.values);
  }

  @Override
  public int hashCode() {
    return Objects.hash(values);
  }
}
