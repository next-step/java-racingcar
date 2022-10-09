package racing;

import util.RandomNumberGenerator;

public class Car {

  public static final int MIN_TO_ALLOW_CAR_MOVE = 4;

  private int location;

  public Car() {
    this.location = 0;
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
    this.location += 1;
  }

  public boolean isMovable() {
    return RandomNumberGenerator.generateUnitsDigit() >= MIN_TO_ALLOW_CAR_MOVE;
  }
}
