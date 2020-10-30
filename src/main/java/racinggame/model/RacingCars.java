package racinggame.model;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import racinggame.vo.CarSateInRace;

public class RacingCars {

  private List<Car> racingCars;

  public RacingCars(int raceCarCount) {
    this.racingCars = preparerCar(raceCarCount);
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

  private List<Car> preparerCar(int raceCarCount) {
    return IntStream.range(0, raceCarCount)
        .mapToObj(index -> new Car(index))
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
