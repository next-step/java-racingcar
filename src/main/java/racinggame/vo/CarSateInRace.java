package racinggame.vo;

import java.util.Objects;

public class CarSateInRace {

  private int carNumber;
  private int racingPosition;

  public CarSateInRace(int carNumber, int racingPosition) {
    this.carNumber = carNumber;
    this.racingPosition = racingPosition;
  }

  public int getCarNumber() {
    return carNumber;
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
    return carNumber == that.carNumber;
  }

  @Override
  public int hashCode() {
    return Objects.hash(carNumber);
  }
}
