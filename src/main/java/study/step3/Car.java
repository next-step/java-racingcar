package study.step3;

public class Car {

  static final private int MINIMUM_MOVE_VALUE = 4;

  private int distance;

  public void move(int moveValue) {
    if (isMoving(moveValue)) {
      distance++;
    }
  }

  private boolean isMoving(int moveValue) {
    return moveValue >= MINIMUM_MOVE_VALUE;
  }

  public int getDistance() {
    return distance;
  }
}
