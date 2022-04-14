package racingCar.model;

public class RacingCarHistory {

  private Integer round;
  private Car car;
  private Integer carSize;

  public RacingCarHistory(Integer round, Car car, Integer carSize) {
    this.round = round;
    this.car = car;
    this.carSize = carSize;
  }

  public Integer round() {
    return round;
  }

  public Car car() {
    return car;
  }

  public Integer carCount() {
    return this.carSize;
  }
}
