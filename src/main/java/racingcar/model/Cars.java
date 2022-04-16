package racingcar.model;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Cars {

  private final List<Car> values;

  public Cars(List<Car> cars) {
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

//  public List<Position> collectPositions() {
//    return values.stream()
//        .map(Car::getPosition)
//        .collect(Collectors.toList());
//  }

  public List<Car> findWinners() {
    Car winnerCar = values.stream()
        .max(Car::compareTo)
        .orElse(null);
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
