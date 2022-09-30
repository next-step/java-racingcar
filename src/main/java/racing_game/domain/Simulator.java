package racing_game.domain;

import racing_game.core.Positive;

public class Simulator {

  private final Cars cars;
  private Positive trialCount;

  private Simulator(Positive CarCount, Positive trialCount) {
    this.cars = Cars.create(CarCount);
    this.trialCount = trialCount;
  }

  public static Simulator create(Config config) {
    return new Simulator(config.getCarCount(), config.getTrialCount());
  }

  public Simulator simulate() {
    for (int i = 0; i < trialCount.toInt(); i++) {
      cars.moveAll();
    }
    return this;
  }

  public Cars getCars() {
    return cars;
  }

  public Positive getTrialCount() {
    return trialCount;
  }
}
