package study1.racing.code;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import study1.racing.code.moveStrategy.RaceMove;

public class RaceRound {

  private final List<Car> cars;

  public RaceRound(List<Car> cars) {
    this.cars = cars;
  }

  public RaceRound(RaceRound raceRound) {
    this.cars = raceRound.cars.stream()
                  .map((car) -> new Car(car))
                  .collect(Collectors.toList());
  }

  public List<Integer> getResult() {
    return cars.stream()
            .map(car -> car.getDistance())
            .collect(Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList));
  }

  public RaceRound move() {
    cars.stream().forEach((car) -> car.move(new RaceMove()));
    return this;
  }
}
