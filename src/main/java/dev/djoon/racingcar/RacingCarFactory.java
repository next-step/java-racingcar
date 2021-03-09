package dev.djoon.racingcar;

import dev.djoon.racingcar.actor.Car;
import dev.djoon.racingcar.actor.Sedan;

public class RacingCarFactory {

  public static Car create() {
    return new Sedan();
  }

  public static Car createWithOwner(String ownerName) {
    return new Sedan(ownerName);
  }
}
