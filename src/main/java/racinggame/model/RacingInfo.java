package racinggame.model;

public class RacingInfo {
  private int time;
  private Cars cars;

  public RacingInfo(int time, Cars cars) {
    this.time = time;
    this.cars = cars;
  }

  public Cars getCars() {
    return cars;
  }

  public int getTime() {
    return time;
  }
}
