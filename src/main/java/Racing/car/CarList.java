package Racing.car;

import Racing.score.Score;
import Racing.stage.Stage;
import Racing.type.RacingNumber;
import java.util.List;
import java.util.stream.Collectors;

public class CarList {

  private final List<Car> cars;

  public CarList(List<Car> cars) {
    this.cars = cars;
  }

  public CarList moveAllCar(Stage stage) {
    this.cars.
        forEach(car -> moveCar(stage, car));
    return this;
  }

  public List<RacingNumber> displayCarDistance() {
    return this.cars.stream()
        .map(Car::presentDistance)
        .collect(Collectors.toList());
  }

  public List<RacingNumber> displayCarDistance(Stage stage) {
    return this.cars.stream()
        .map(car -> car.presentDistance(stage))
        .collect(Collectors.toList());
  }

  public RacingNumber size() {
    return new RacingNumber(cars.size());
  }


  private Car moveCar(Stage stage, Car car) {
    Score score = new Score(stage);
    return car.move(score);
  }

}
