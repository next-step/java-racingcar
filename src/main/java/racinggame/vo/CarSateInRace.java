package racinggame.vo;

import java.util.Objects;

public class CarSateInRace {

  private String carName;
  private int racingPosition;

  public CarSateInRace( String carName, int racingPosition) {
    this.carName = carName;
    this.racingPosition = racingPosition;
  }

  public String getCarName() {
    return carName;
  }

  public int getRacingPosition() {
    return racingPosition;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CarSateInRace that = (CarSateInRace) o;
    return carName == that.carName;
  }

  @Override
  public int hashCode() {
    return Objects.hash(carName);
  }
}
