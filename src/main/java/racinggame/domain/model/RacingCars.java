package racinggame.domain.model;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import racinggame.domain.Car;
import racinggame.vo.CarSateInRace;

public class RacingCars {

  private List<Car> racingCars;

  public RacingCars(String[] racingCarNames) {
    this.racingCars = preparerCar(Arrays.asList(racingCarNames.clone()));
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

  private List<Car> preparerCar(List<String> racingCarNames) {
    return racingCarNames.stream()
        .map(racingCarName -> new Car(racingCarName))
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
