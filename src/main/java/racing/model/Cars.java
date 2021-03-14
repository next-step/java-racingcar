package racing.model;

import racing.util.RandomGenerator;

import java.util.List;

public class Cars {
  private final List<Car> cars;

  public Cars(List<Car> cars) {
    this.cars = cars;
  }

  public List<Car> getCars(){
    return cars;
  }

  public boolean runCycle() {
    cars.forEach(Car::move);
    return true;
  }
}
