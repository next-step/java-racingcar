package Racing;

import java.util.List;
import java.util.stream.Collectors;

public class CarList {

  private final List<Car> cars;

  public CarList(List<Car> cars) {
    this.cars = cars;
  }

  public CarList moveAllCar() {
    this.cars.stream()
        .forEach(Car::move);
    return this;
  }

  public String displayCarDistance() {
    return this.cars.stream()
        .map(Car::presentDistance)
        .collect(Collectors.joining("\n"));
  }

}
