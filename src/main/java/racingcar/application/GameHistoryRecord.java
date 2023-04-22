package racingcar.application;

public class GameHistoryRecord {
  private final Cars cars;

  public GameHistoryRecord(Cars cars) {
    this.cars = cars.clone();
  }

  public Cars cars() {
    return cars;
  }
}
