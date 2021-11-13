package Racing;

import Racing.car.Car;
import Racing.car.CarList;
import Racing.stage.Stage;
import Racing.stage.StageStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Racing {

  private final CarList cars;

  public Racing(int countOfCar) {
    List<Car> cars = IntStream.range(0, countOfCar).mapToObj(i -> new Car()).collect(Collectors.toList());

    this.cars = new CarList(cars);
  }

  public String run(int countOfStage) {
    List<Stage> stages = new ArrayList<>();

    for(int i = 0; i < countOfStage; i ++){
      stages.add(new Stage());
    }

    return stages.stream()
            .filter(targetStage -> targetStage.status.equals(StageStatus.READY))
            .map((this::getCarsDisplay))
            .collect(Collectors.joining());
  }

  private String getCarsDisplay(Stage stage) {
    stage.moveCars(cars);
    return cars.displayCarDistance()+"\n\n";
  }
}
