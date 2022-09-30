package racing_game.domain;

import racing_game.core.Positive;

public class Config {

  private Positive carCount;
  private Positive tryCount;

  private Config(Positive carCount, Positive tryCount) {
    this.carCount = carCount;
    this.tryCount = tryCount;
  }

  public static Config create(Positive carCount, Positive tryCount) {
    return new Config(carCount, tryCount);
  }

  public Positive getCarCount() {
    return carCount;
  }

  public Positive getTryCount() {
    return tryCount;
  }
}
