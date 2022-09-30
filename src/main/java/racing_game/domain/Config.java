package racing_game.domain;

import racing_game.core.Positive;

public class Config {

  private Positive carCount;
  private Positive trialCount;

  private Config(Positive carCount, Positive trialCount) {
    this.carCount = carCount;
    this.trialCount = trialCount;
  }

  public static Config create(Positive carCount, Positive trialCount) {
    return new Config(carCount, trialCount);
  }

  public Positive getCarCount() {
    return carCount;
  }

  public Positive getTrialCount() {
    return trialCount;
  }
}
