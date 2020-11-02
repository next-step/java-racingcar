package racinggame.model;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import racinggame.vo.CarSateInRace;

public class RacingCars {

  private List<Car> racingCars;

  public RacingCars(String[] racingCarNames) {
    this.racingCars = preparerCar(racingCarNames);
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

  private List<Car> preparerCar(String[] racingCarNames) {
    return IntStream.range(0, racingCarNames.length)
        .mapToObj(index -> new Car(racingCarNames[index]))
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
