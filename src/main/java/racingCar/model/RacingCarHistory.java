package racingCar.model;

public class RacingCarHistory {

  private Integer round;
  private Car car;
  private Integer carIndex;

  public RacingCarHistory(Integer round, Car car, Integer carIndex) {
    this.round = round;
    this.car = car;
    this.carIndex = carIndex;
  }

  public Integer round() {
    return round;
  }

  public Car car() {
    return car;
  }

  public Integer carIndex() {
    return this.carIndex;
  }
}
