package study1.racing;

import java.util.List;
import java.util.stream.Collectors;

public class RaceRound {

  private List<Car> cars;

  public RaceRound(List<Car> cars) {
    this.cars = cars;
  }

  public List<Integer> getResult() {
    return cars.stream()
            .map(car -> car.getDistance())
            .collect(Collectors.toList());
  }
}
