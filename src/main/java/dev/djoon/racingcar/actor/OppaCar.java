package dev.djoon.racingcar.actor;

public class OppaCar extends Car {

  public OppaCar() {
    this.enginePower = 1;
    this.xPosition = 0;
    this.owner = "";
  }

  public OppaCar(String owner) throws IllegalArgumentException {
    if (owner.length() > 5) {
      throw new IllegalArgumentException("A owner name cannot be longer than 5 : " + owner);
    }
    this.enginePower = 1;
    this.xPosition = 0;
    this.owner = owner;
  }

}
