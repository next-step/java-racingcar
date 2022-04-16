package racingcar.model;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Cars {

  private static final int CARS_MIN_COUNT = 1;

  private final List<Car> values;

  public Cars(List<Car> cars) {
    this.values = cars;
  }

  public static Cars createCars(List<String> carNames, int startPosition) {
    validateCount(carNames);
    List<Car> cars = carNames.stream()
        .map(name -> new Car(startPosition, name))
        .collect(Collectors.toList());
    return new Cars(cars);
  }

  public void move(MovingStrategy movingStrategy) {
    values.forEach(car -> car.moveOrStop(movingStrategy));
  }

  public List<Position> collectPositions() {
    return values.stream()
        .map(Car::getPosition)
        .collect(Collectors.toList());
  }

  public int size() {
    return values.size();
  }

  private static void validateCount(List<String> carNames) {
    if (carNames.size() < CARS_MIN_COUNT) {
      throw new RuntimeException(String.format("자동차는 %d대 이상이어야 합니다.", CARS_MIN_COUNT));
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
