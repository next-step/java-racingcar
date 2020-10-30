package racinggame.model;

import java.util.Objects;
import racinggame.rule.MoveRule;
import racinggame.rule.RandomMoveRule;
import racinggame.vo.CarSateInRace;

public class Car {

  private final int INIT_RACE_POSITION = 0;

  private int carNumber;
  private int racingPosition;
  private MoveRule moveRule;

  public Car(int carNumber) {
    this.carNumber = carNumber;
    this.racingPosition = INIT_RACE_POSITION;
    this.moveRule = new RandomMoveRule();
  }

  public Car(int carNumber, MoveRule moveRule) {
    this.carNumber = carNumber;
    this.racingPosition = INIT_RACE_POSITION;
    this.moveRule = moveRule;
  }

  public int getRacingPosition() {
    return racingPosition;
  }

  public CarSateInRace go() {
    updateRacePosition(moveRule.isAbleToMove());
    return new CarSateInRace(this.carNumber, this.racingPosition);
  }

  private int updateRacePosition(boolean goingPossible) {
    return goingPossible ? ++racingPosition : this.racingPosition;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Car car = (Car) o;
    return carNumber == car.carNumber;
  }

  @Override
  public int hashCode() {
    return Objects.hash(carNumber);
  }
}
