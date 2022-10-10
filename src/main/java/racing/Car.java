package racing;

import util.RandomNumberGenerator;

public class Car {

  public static final int START_LOCATION = 1;
  public static final int DISTANCE_TO_MOVE_AT_ONCE = 1;
  public static final int MIN_TO_ALLOW_CAR_MOVE = 4;

  private int location;

  public Car() {
    this.location = START_LOCATION;
  }

  public int nowLocation() {
    return location;
  }

  public void moveIfMovable(){
    if (this.isMovable()) {
      this.move();
    }
  }

  public void move() {
    this.location += DISTANCE_TO_MOVE_AT_ONCE;
  }

  public boolean isMovable() {
    return RandomNumberGenerator.generateUnitsDigit() >= MIN_TO_ALLOW_CAR_MOVE;
  }
}
