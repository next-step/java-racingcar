package dev.djoon.racingcar.actor;

import dev.djoon.racingcar.util.GameConstant;

public abstract class Car {

  protected int xPosition;
  protected int enginePower;
  protected String owner;

  private void move() {
    this.xPosition += enginePower;
  }

  public int getXPosition() {
    return xPosition;
  }

  public String getOwner() {
    return owner;
  }

  public boolean moveIfValidCondition(int number) {
    if (number >= GameConstant.VALID_BOUNDARY.value()) {
      move();
      return true;
    }
    return false;
  }
}
