package study.racing.domain;

public class Distance {

  public static final int MOVE_DISTANCE = 1;
  private int moveDistance;

  public Distance() {
  }

  public int getMoveDistance() {
    return moveDistance;
  }

  public void move() {
    moveDistance += MOVE_DISTANCE;
  }

  public int getMaxValue(int max) {
    return Math.max(moveDistance, max);
  }

  public boolean isMax(int distance, int max) {
    return distance > max;
  }

  public boolean isSameToMaxDistance(int maxMoveDistance) {
    return moveDistance == maxMoveDistance;
  }

}
