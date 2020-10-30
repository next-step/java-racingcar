package racinggame.model;

import java.util.List;
import java.util.Objects;
import racinggame.vo.CarSateInRace;

/*
우승자 결정로직을 위한 클래스
 */
public class MovingResult {

  private List<CarSateInRace> carSateInRaces;

  public MovingResult(List<CarSateInRace> carSateInRaces) {
    this.carSateInRaces = carSateInRaces;
  }

  public List<CarSateInRace> getCarSateInRaces() {
    return carSateInRaces;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MovingResult that = (MovingResult) o;
    return Objects.equals(carSateInRaces, that.carSateInRaces);
  }

  @Override
  public int hashCode() {
    return Objects.hash(carSateInRaces);
  }
}
