package dev.djoon.racingcar.actor;

public abstract class Car {

  protected int xPos;
  protected int enginePower;

  public void move() {
    this.xPos += enginePower;
  }

  public int getXPos() {
    return xPos;
  }
}
