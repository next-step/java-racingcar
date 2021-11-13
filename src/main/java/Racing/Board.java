package Racing;

import java.util.List;

public class Board {

  private CarList cars;
  private List<Stage> stages;

  public Board(CarList cars, List<Stage> stages) {
    this.cars = cars;
    this.stages = stages;
  }

  public CarList startStage() {
    Stage stage = stages.stream()
        .filter(targetStage -> targetStage.status.equals(StageStatus.READY))
        .findFirst()
        .orElseThrow();
    return cars.moveAllCar();
  }

}
