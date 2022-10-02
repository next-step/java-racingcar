package racing_game.domain;

import racing_game.core.Positive;

public class SimulationConfig {

  private final Positive carCount;
  private final Positive tryCount;

  private SimulationConfig(Positive carCount, Positive tryCount) {
    this.carCount = carCount;
    this.tryCount = tryCount;
  }

  public static SimulationConfig create(Positive carCount, Positive tryCount) {
    return new SimulationConfig(carCount, tryCount);
  }

  public Positive getCarCount() {
    return carCount;
  }

  public Positive getTryCount() {
    return tryCount;
  }
}
