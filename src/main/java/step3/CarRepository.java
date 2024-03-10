package step3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CarRepository {
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
}
