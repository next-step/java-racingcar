package racingCar.car;

import racingCar.car.move.RacingCarMoveDirectionStrategy;
import racingCar.car.move.RacingCarMoveServiceLocator;
import racingCar.exception.InvalidRacingCarNameException;
import util.RandomUtils;
import util.StringUtils;

public class RacingCar {

  private static final int ALLOWED_NAME_LENGTH = 5;
  private final String carName;
  private final RacingCarMoveServiceLocator moveServiceLocator;
  private int position;

  public RacingCar(String carName, RacingCarMoveServiceLocator moveServiceLocator) {
    throwErrorIfCarNameExceed(carName);
    this.carName = carName;
    this.position = 0;
    this.moveServiceLocator = moveServiceLocator;
  }

  public void moveIfPossible() {
    final int randomMoveAck = getRandomMoveAck();
    RacingCarMoveDirectionStrategy moveStrategy = moveServiceLocator.getRacingCarMoveStrategy(randomMoveAck);
    if (moveStrategy != null) {
      moveStrategy.moveAndSetPosition(this);
    }
  }

  public int getPosition() {
    return position;
  }

  public String getCarName() {
    return carName;
  }

  public void moveForward() {
    this.position++;
  }

  protected int getRandomMoveAck () {
    return RandomUtils.getRandomSinglePositiveDigit();
  }

  private void throwErrorIfCarNameExceed(String carName) {
    if (StringUtils.isBlank(carName)) {
      throw new InvalidRacingCarNameException("자동차의 이름이 없습니다.");
    }

    if (carName.length() > ALLOWED_NAME_LENGTH) {
      throw new InvalidRacingCarNameException(String.format(
          "자동차의 이름이 %d 글자입니다. %d자 이하로 설정해주세요", carName.length(), ALLOWED_NAME_LENGTH
      ));
    }
  }
}
