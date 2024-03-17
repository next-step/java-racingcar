package racingcar.domain;

import java.util.*;

public class Cars implements Iterable<Car> {
  private final List<Car> cars = new ArrayList<>();

  public Cars() {
  }

  public Cars(List<Car> cars) {
    this.cars.addAll(cars);
  }

  public List<Car> cars() {
    return this.cars;
  }

  public void addEmptyCar() {
    this.cars.add(new Car());
  }

  public void addCar(final Car car) {
    this.cars.add(car);
  }

  public void addEmptyCars(final int numberOfCars) {
    for (int i = 0; i < numberOfCars; i++) {
      this.addEmptyCar();
    }
  }

  public void moveAllCars(int[] conditions) {
    final int STARTING_INDEX = 0;

    int index = STARTING_INDEX;
    for (Car car : this.cars) {
      car.moveConditionally(new Condition(conditions[index]));
      index++;
    }
  }

  public int size() {
    return this.cars.size();
  }

  public long numberOfCarsWithLocationOf(final int location) {
    return this.cars.stream()
            .filter(car -> car.isLocatedAt(location))
            .count();
  }

  public Cars leadingCars() {
    if (this.cars.isEmpty()) {
      return new Cars();
    }

    Car leadingCar = leadingCar();
    Cars leadingCars = new Cars();
    for (Car car : this.cars) {
      leadingCars.addIfEqualLocation(car, leadingCar);
    }

    return leadingCars;
  }

  private void addIfEqualLocation(final Car target, final Car leadingCar) {
    if (target.atTheSameLocationWith(leadingCar)) {
      this.cars.add(target);
    }
  }

  private Car leadingCar() {
    if (this.cars.isEmpty()) {
      throw new IllegalStateException("There is no car.");
    }

    Car furthest = this.cars.get(0);
    for (Car car : this.cars) {
      furthest = furthest.furtherCar(car);
    }
    return furthest;
  }

  private List<Car> addCarConditionally(final List<Car> furthestCars, final Car furthest, final Car target) {
    if (target.furtherThan(furthest)) {
      List<Car> newFurthestCars = new ArrayList<>();
      newFurthestCars.add(target);
      return newFurthestCars;
    }

    if (target.atTheSameLocationWith(furthest)) {
      furthestCars.add(target);
    }

    return furthestCars;
  }

  public boolean hasCarFurtherThan(Car target) {
    return this.cars.stream()
            .anyMatch(car -> car.furtherThan(target));
  }

  @Override
  public Iterator<Car> iterator() {
    return new CarIterator();
  }

  private class CarIterator implements Iterator<Car> {
    private int cursor = 0;
    @Override
    public boolean hasNext() {
      return cursor < cars.size();
    }

    @Override
    public Car next() {;
      return cars.get(cursor++);
    }
  }
}
