package racing.simulator;

import racing.types.RacingCarName;

public class RacingCar {

  private RacingCarName carName;
  private int location;

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

  public void go(RacingCarMovingStrategy racingCarMovingStrategy) {
    if (racingCarMovingStrategy.canMove()) {
      this.location += 1;
    }
  }

  public void reset() {
    location = 0;
  }
}
