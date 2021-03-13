package dev.djoon.racingcar.domain;

public class RacingCarFactory {

  public static Car create() {
    return new Sedan();
  }

  public static Car createWithOwner(String ownerName) {
    return new Sedan(ownerName);
  }
}
