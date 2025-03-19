package racingcar;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Cars {
  private final List<Car> cars;

  public Cars(List<Car> cars) {
    this.cars = List.copyOf(cars);
  }

  public List<Car> getCars() {
    return Collections.unmodifiableList(cars);
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
