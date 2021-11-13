package Racing;

import java.util.ArrayList;
import java.util.List;

public class Racing {

  static final private String SPLIT_TOKEN = "\n";

  private final CarList cars;

  public Racing(int countOfCar) {
    List<Car> cars = new ArrayList<>();

    for (int i = 0; i < countOfCar; i++) {
      cars.add(new Car());
    }
    this.cars = new CarList(cars);
  }

  public String run(int countOfStage) {
    List<Stage> stages = new ArrayList<>();

    for (int i = 0; i < countOfStage; i++) {
      stages.add(new Stage());
    }

    stages.stream()
        .forEach(stage -> stage.moveCars(cars));
    return cars.displayCarDistance();
  }
}
