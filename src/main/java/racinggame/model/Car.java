package racinggame.model;

import static racinggame.message.MessageConstant.CAR_NAME_LENGTH_IS_UNDER_FIVE;

import java.util.Objects;
import racinggame.rule.MoveRule;
import racinggame.rule.RandomMoveRule;
import racinggame.vo.CarSateInRace;

public class Car {

  private static final int INIT_RACE_POSITION = 0;
  private static final int MAX_CAR_NAME_LENGTH = 5;

  private String carName;
  private int racingPosition;
  private MoveRule moveRule;

  public Car(String carName) {
    checkCarNameMaxLength(carName);
    this.carName = carName;
    this.racingPosition = INIT_RACE_POSITION;
    this.moveRule = new RandomMoveRule();
  }

  public Car(String carName, MoveRule moveRule) {
    checkCarNameMaxLength(carName);
    this.carName = carName;
    this.racingPosition = INIT_RACE_POSITION;
    this.moveRule = moveRule;
  }

  public int getRacingPosition() {
    return racingPosition;
  }

  public CarSateInRace go() {
    updateRacePosition(moveRule.isAbleToMove());
    return new CarSateInRace(this.carName, this.racingPosition);
  }

  private int updateRacePosition(boolean goingPossible) {
    return goingPossible ? ++racingPosition : this.racingPosition;
  }

  private void checkCarNameMaxLength(String carName) {
    if (carName.length() > MAX_CAR_NAME_LENGTH) {
      throw new IllegalArgumentException(CAR_NAME_LENGTH_IS_UNDER_FIVE);
    }
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
    return Objects.equals(carName, car.carName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(carName);
  }
}
