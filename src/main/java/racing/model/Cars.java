package racing.model;

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
    // TODO: Move할 때 strategy 주입해야 함
    cars.forEach(Car::move);
    return true;
  }
}
