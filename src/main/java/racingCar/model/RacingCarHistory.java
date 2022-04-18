package racingCar.model;

public final class RacingCarHistory {

  private final Integer round;
  private final Car car;

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
    return car.toString();
  }
}
