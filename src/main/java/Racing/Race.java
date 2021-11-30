package Racing;

import Racing.car.Car;
import Racing.car.CarList;
import Racing.stage.Stage;
import Racing.type.RacingNumber;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Race {

  private final CarList cars;
  private final List<Stage> stages;

  public Race(RacingNumber countOfCar, RacingNumber countOfStage) {
    List<Car> cars = countOfCar.generateInstanceList(Car.class);
    this.stages = countOfStage.generateInstanceList(Stage.class);
    this.cars = new CarList(cars);
  }

  public Map<Stage, List<RacingNumber>> getHistory() {
    return stages.stream()
        .collect(
            Collectors.toMap(
                stage -> stage,
                stage -> cars.displayCarDistance(stage)
            )
        );
  }

  public CarList run() {
    stages.forEach((stage) -> stage.moveCars(cars));
    return cars;
  }
}
