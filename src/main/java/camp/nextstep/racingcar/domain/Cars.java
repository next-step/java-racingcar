package camp.nextstep.racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {

  private final List<Car> cars;

  public Cars(List<Car> cars) {
    this.cars = cars;
  }

  public int size() {
    return cars.size();
  }

  public List<CarRecord> race(MoveCondition moveCondition) {
    List<CarRecord> carRecords = new ArrayList<>();
    for (Car car : cars) {
      car.move(moveCondition);
      carRecords.add(new CarRecord(car.getPosition()));
    }
    return carRecords;
  }

}
