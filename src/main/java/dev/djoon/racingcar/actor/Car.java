package dev.djoon.racingcar.actor;

public abstract class Car {

  protected int xPosition;
  protected int enginePower;

  private void move() {
    this.xPosition += enginePower;
  }

  public int getXPosition() {
    return xPosition;
  }

  public boolean moveIfValidCondition(int number) {
    if (number >= 4) {
      move();
      return true;
    }
    return false;
  }
}
