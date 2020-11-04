package racinggame.domain.model;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import racinggame.domain.Car;
import racinggame.domain.rule.MoveRule;
import racinggame.vo.CarSateInRace;

public class RacingCars {

  private List<Car> racingCars;

  public RacingCars(String[] racingCarNames, MoveRule moveRule) {
    this.racingCars = Arrays.stream(racingCarNames)
        .map(racingCarName -> Car.of(racingCarName, moveRule))
        .collect(Collectors.toList());
  }

  public RacingCars(List<Car> racingCars) {
    this.racingCars = racingCars;
  }

  public MovingResult racing() {
    return new MovingResult(orderRacing());
  }

  private List<CarSateInRace> orderRacing() {
    return this.racingCars.stream()
        .map(car -> car.go())
        .collect(Collectors.toList());
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RacingCars that = (RacingCars) o;
    return Objects.equals(racingCars, that.racingCars);
  }

  @Override
  public int hashCode() {
    return Objects.hash(racingCars);
  }
}
