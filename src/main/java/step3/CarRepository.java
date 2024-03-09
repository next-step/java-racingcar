package step3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CarRepository {
  private final List<Car> cars = new ArrayList<>();

  private static final Random random = new Random();

  public void addCar() {
    this.cars.add(new Car());
  }

  public void addCar(final Car car) {
    this.cars.add(car);
  }

  public void addCars(final int numberOfCars) {
    for (int i = 0; i < numberOfCars; i++) {
      this.addCar();
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
}
