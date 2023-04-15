package racingCar.car;

import racingCar.car.move.RacingCarMoveDirectionStrategy;
import racingCar.car.move.RacingCarMoveServiceLocator;

public class RacingCar {

  private final long carId;
  private final RacingCarMoveServiceLocator moveServiceLocator;
  private int position;

  public RacingCar (long carId, RacingCarMoveServiceLocator moveServiceLocator) {
    this.carId = carId;
    this.position = 0;
    this.moveServiceLocator = moveServiceLocator;
  }

  public void moveIfPossible(int moveAck) {
    RacingCarMoveDirectionStrategy moveStrategy = moveServiceLocator.getRacingCarMoveStrategy(moveAck);
    if (moveStrategy != null) {
      moveStrategy.moveAndSetPosition(this);
    }
  }

  public int getPosition() {
    return position;
  }

  public void moveForward() {
    this.position++;
  }
}
