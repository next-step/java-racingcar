package racinggame.domain;

import static racinggame.message.MessageConstant.CAR_NAME_LENGTH_IS_UNDER_FIVE;

import java.util.Objects;
import racinggame.domain.rule.MoveRule;
import racinggame.domain.rule.RandomMoveRule;
import racinggame.vo.CarSateInRace;

public class Car {

  private static final int INIT_RACE_POSITION = 0;
  private static final int MAX_CAR_NAME_LENGTH = 5;

  private String carName;
  private int racingPosition;
  private MoveRule moveRule;

  private Car() {}

  private Car(String carName) {
    this.carName = carName;
    this.moveRule = new RandomMoveRule();
  }

  private Car(String carName, MoveRule moveRule) {
    this.carName = carName;
    this.racingPosition = INIT_RACE_POSITION;
    this.moveRule = moveRule;
  }

  public static Car newInstanceByCarName(String carName) {
    return new Car(carName);
  }

  public static Car of(String carName, MoveRule moveRule) {
    return new Car(carName, moveRule);
  }

  public int getRacingPosition() {
    return racingPosition;
  }

  public CarSateInRace go() {
    checkCarNameMaxLength(carName);
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
