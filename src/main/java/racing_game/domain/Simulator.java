package racing_game.domain;

import racing_game.core.Positive;

public class Simulator {

  private final Cars cars;
  private final Positive tryCount;

  private Simulator(Positive carCount, Positive tryCount) {
    this.cars = Cars.create(carCount);
    this.tryCount = tryCount;
  }

  public static Simulator create(SimulationConfig simulationConfig) {
    return new Simulator(simulationConfig.getCarCount(), simulationConfig.getTryCount());
  }

  public Simulator simulate() {
    for (int i = 0; i < tryCount.toInt(); i++) {
      cars.moveAll();
    }
    return this;
  }

  public Cars getCars() {
    return cars;
  }

  public Positive getTryCount() {
    return tryCount;
  }
}
