package racing.types;

import racing.simulator.RacingCarMovingStrategy;

public class RacingCar {

  private final RacingCarName carName;
  private int location;

  public RacingCar() {
    this(new RacingCarName());
  }

  public RacingCar(RacingCarName carName) {
    this.carName = carName;
    this.location = 0;
  }

  public RacingCar(RacingCar racingCar) {
    this.location = racingCar.location;
    this.carName = racingCar.carName;
  }

  public int getLocation() {
    return location;
  }

  public String getName() {
    return carName.getName();
  }

  public void go(RacingCarMovingStrategy racingCarMovingStrategy) {
    if (racingCarMovingStrategy.canMove()) {
      this.location += 1;
    }
  }

  public void reset() {
    location = 0;
  }
}
