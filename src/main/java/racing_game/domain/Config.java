package racing_game.domain;

import racing_game.core.Positive;

public class Config {

  private Positive numberOfCars;
  private Positive numberOfTrials;

  private Config(Positive numberOfCars, Positive numberOfTrials) {
    this.numberOfCars = numberOfCars;
    this.numberOfTrials = numberOfTrials;
  }

  public static Config create(Positive numberOfCars, Positive numberOfTrials) {
    return new Config(numberOfCars, numberOfTrials);
  }

  public Positive getNumberOfCars() {
    return numberOfCars;
  }

  public Positive getNumberOfTrials() {
    return numberOfTrials;
  }
}
