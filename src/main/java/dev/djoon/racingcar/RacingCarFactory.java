package dev.djoon.racingcar;

import dev.djoon.racingcar.actor.Car;
import dev.djoon.racingcar.actor.OppaCar;

public class RacingCarFactory {

  public static Car create() {
    return new OppaCar();
  }

  public static Car createWithOwner(String ownerName) {
    return new OppaCar(ownerName);
  }
}
