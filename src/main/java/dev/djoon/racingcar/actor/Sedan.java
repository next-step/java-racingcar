package dev.djoon.racingcar.actor;

public class Sedan extends Car {

  public Sedan() {
    super();
    this.enginePower = 1;
  }

  public Sedan(String owner) throws IllegalArgumentException {
    super(owner);
    this.enginePower = 1;
  }

}
