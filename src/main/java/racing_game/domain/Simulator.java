package racing_game.domain;

import racing_game.core.Positive;

public class Simulator {

  private Cars cars;
  private Positive numberOfTrials;

  private Simulator(Positive numberOfCars, Positive numberOfTrials) {
    this.cars = Cars.create(numberOfCars);
    this.numberOfTrials = numberOfTrials;
  }

  public static Simulator create(Config config) {
    return new Simulator(config.getNumberOfCars(), config.getNumberOfTrials());
  }

  public Simulator simulate() {
    for (int i = 0; i < numberOfTrials.toInteger(); i++) {
      cars.moveAll();
    }
    return this;
  }

  public Cars getCars() {
    return cars;
  }

  public Positive getNumberOfTrials() {
    return numberOfTrials;
  }
}
