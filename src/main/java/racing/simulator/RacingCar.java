package racing.simulator;

public class RacingCar {

  private int location;

  public RacingCar() {
    this.location = 0;
  }

  public RacingCar(RacingCar racingCar) {
    this.location = racingCar.location;
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
