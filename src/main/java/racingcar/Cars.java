package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Cars {
  private final List<Car> cars = new ArrayList<>();

  private static final Random random = new Random();

  public void addEmptyCar() {
    this.cars.add(new Car());
  }

  public void addCar(final Car car) {
    this.cars.add(car);
  }

  public void addCars(final int numberOfCars) {
    for (int i = 0; i < numberOfCars; i++) {
      this.addEmptyCar();
    }
  }

  public void moveAllCars() {
    for (Car car : this.cars) {
      car.moveConditionally(random.nextInt(10));
    }
  }

  public int getNumberOfCars() {
    return this.cars.size();
  }

  public List<Car> getCars() {
    return this.cars;
  }

  public boolean containsCarWithLocationOf(final int location) {
    return this.cars.stream().anyMatch(car -> car.isLocationValueOf(location));
  }

  public int size() {
    return this.cars.size();
  }

  public long sizeOfCarsWithLocationOf(final int location) {
    return this.cars.stream().filter(car -> car.isLocationValueOf(location)).count();
  }

  public List<Car> leadingCars() {
    if (this.cars.isEmpty()) {
      return List.of();
    }

    List<Car> leadingCars = new ArrayList<>();
    Car leadingCar = leadingCar();

    for (Car car : this.cars) {
      leadingCars = addCarConditionally(leadingCars, leadingCar, car);
    }

    return leadingCars;
  }

  private Car leadingCar() {
    Car leadingCar = this.cars.get(0);

    for (Car car : this.cars) {
      leadingCar = leader(car, leadingCar);
    }

    return leadingCar;
  }

  private Car leader(Car car1, Car car2) {
    if (car1.isAheadOf(car2)) {
      return car1;
    }

    if (car1.isBehind(car2)) {
      return car2;
    }

    return car1;
  }

  List<Car> addCarConditionally(List<Car> cars, Car comparison, Car target) {
    if (target.isAheadOf(comparison)) {
      List<Car> leadingCars = new ArrayList<>();
      leadingCars.add(target);
      return leadingCars;
    }

    if (target.atTheSameLocationWith(comparison)) {
      cars.add(target);
    }

    return cars;
  }
}
