package camp.nextstep.racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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
      carRecords.add(new CarRecord(car.getName(), car.getPosition()));
    }
    return carRecords;
  }

  public List<Car> getWinners() {
    Car winner = Collections.max(cars, Comparator.comparing(Car::getPosition));
    return cars.stream()
        .filter(winner::isSamePosition)
        .collect(Collectors.toList());
  }

}
