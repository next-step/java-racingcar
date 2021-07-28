package study.racing.domain;

import java.util.Objects;

public class Distance {

  private int moveDistance;
  
  public static final int MOVE_DISTANCE = 1;

  public Distance() {

  }

  public Distance(int moveDistance) {
    this.moveDistance = moveDistance;
  }

  public int getMoveDistance() {
    return moveDistance;
  }

  public void move() {
    moveDistance += MOVE_DISTANCE;
  }

  public Distance moveAndReturnObject(){
    return new Distance(moveDistance += MOVE_DISTANCE);
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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Distance distance = (Distance) o;
    return getMoveDistance() == distance.getMoveDistance();
  }

  @Override
  public int hashCode() {
    return Objects.hash(getMoveDistance());
  }
}
