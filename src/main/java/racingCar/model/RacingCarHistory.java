package racingCar.model;

public class RacingCarHistory {

  private Integer round;
  private Car car;

  public RacingCarHistory(Integer round, Car car) {
    this.round = round;
    this.car = car;
  }

  public Integer round() {
    return round;
  }

  public Car car() {
    return car;
  }


  @Override
  public String toString() {
    return "RacingCarHistory{" +
        "round=" + round +
        ", car=" + car;
  }
}
