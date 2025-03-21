package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Cars {
  private final List<Car> cars;

  public Cars(List<Car> cars) {
    this.cars = List.copyOf(cars);
  }

  public static Cars fromNames(List<String> names) {
    List<Car> cars = names.stream()
        .map(Car::new)
        .collect(Collectors.toList());
    return new Cars(cars);
  }

  public Cars withAddedCar(Car car) {
    List<Car> newCars = new ArrayList<>(this.cars);
    newCars.add(car);
    return new Cars(newCars);
  }

  public List<Car> getCars() {
    return Collections.unmodifiableList(cars);
  }

  public List<String> getWinners(Cars records) {
    int maxPosition = getMaxPosition(records);
    return records.stream()
        .filter(car -> car.getPosition() == maxPosition)
        .map(Car::getName)
        .collect(Collectors.toList());
  }

  private int getMaxPosition(Cars records) {
    return records.stream()
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
