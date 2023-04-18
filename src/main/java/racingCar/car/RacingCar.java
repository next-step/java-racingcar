package racingCar.car;

import racingCar.car.move.RacingCarMoveDirectionStrategy;
import racingCar.car.move.RacingCarMoveForward;
import racingCar.car.move.RacingCarName;
import racingCar.car.move.RacingCarPosition;
import racingCar.random.RandomMoveAckGenerator;

public class RacingCar {

  private static final int MIN_MOVE_ALLOWED_TRY = 4;
  private final RacingCarName carName;
  private final RacingCarPosition position;
  private final RandomMoveAckGenerator randomMoveAckGenerator;

  public RacingCar(String carName, RandomMoveAckGenerator randomMoveAckGenerator) {
    this.carName = new RacingCarName(carName);
    this.position = new RacingCarPosition(0);
    this.randomMoveAckGenerator = randomMoveAckGenerator;
  }

  public void moveIfPossible() {
    final int randomMoveAck = randomMoveAckGenerator.generate();
    RacingCarMoveDirectionStrategy moveStrategy = getDirectionFromMoveAck(randomMoveAck);
    if (moveStrategy != null) {
      moveStrategy.moveAndSetPosition(this);
    }
  }

  public int getPosition() {
    return position.getPosition();
  }

  public String getCarName() {
    return carName.getName();
  }

  public RacingCarPosition moveForward() {
    return this.position.moveForward();
  }

  private RacingCarMoveDirectionStrategy getDirectionFromMoveAck (int moveAck) {
    if (moveAck >= MIN_MOVE_ALLOWED_TRY) {
      return RacingCarMoveForward.getInstance();
    }
    return null;
  }
}
