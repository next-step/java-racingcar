package Racing.car;

import Racing.stage.Stage;

import java.util.List;
import java.util.stream.Collectors;

public class CarList {

  private final List<Car> cars;

  public CarList(List<Car> cars) {
    this.cars = cars;
  }

  public CarList moveAllCar(Stage stage) {
    this.cars.
            forEach(car -> car.move(stage));
    return this;
  }

  public String displayCarDistance() {
    return this.cars.stream()
        .map(Car::presentDistance)
        .collect(Collectors.joining("\n"));
  }

}
