package racingCar.car;

public class RacingCar {

  private final long carId;
  private long position;

  private static final int MIN_MOVE_ALLOWED_TRY = 4;

  public RacingCar (long carId) {
    this.carId = carId;
    this.position = 0;
  }

  public void moveIfPossible(int moveAck) {
    if (isMoveTrySuccess(moveAck)) {
      position++;
    }
  }

  private boolean isMoveTrySuccess(int moveAck) {
    return moveAck >= MIN_MOVE_ALLOWED_TRY;
  }

  public long getPosition() {
    return position;
  }
}
