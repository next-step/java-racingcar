package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Cars {
  private final List<Car> cars;

  public Cars(List<Car> cars) {
    this.cars = cars;
  }

  public static Cars fromNames(List<String> names) {
    List<Car> cars = names.stream()
        .map(Car::new)
        .collect(Collectors.toList());
    return new Cars(cars);
  }

  public List<Car> getCars() {
    return cars;
  }

  public List<String> getWinners() {
    int maxPosition = getMaxPosition();
    return cars.stream()
        .filter(car -> car.equalsPosition(maxPosition))
        .map(Car::getName)
        .collect(Collectors.toList());
  }

  private int getMaxPosition() {
    return cars.stream()
        .mapToInt(Car::getPosition)
        .max()
        .orElse(0);
  }

  public Stream<Car> stream() {
    return cars.stream();
  }

  public int size() {
    return cars.size();
  }

  public Car get(int index) {
    return cars.get(index);
  }

}
