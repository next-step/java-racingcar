package racingCar.domain.car;

import racingCar.domain.car.move.RacingCarMoveDirectionStrategy;
import racingCar.domain.car.move.RacingCarMoveForward;
import racingCar.domain.car.name.RacingCarName;
import racingCar.domain.car.position.RacingCarPosition;
import racingCar.domain.random.MoveAckGenerator;

public class RacingCar {

  private static final int MIN_MOVE_ALLOWED_TRY = 4;

  private final RacingCarName carName;
  private final RacingCarPosition position;
  private final MoveAckGenerator randomMoveAckGenerator;

  public RacingCar(String carName, MoveAckGenerator randomMoveAckGenerator) {
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

  public boolean isPosition(int position) {
    return this.position.getPosition() == position;
  }
}
