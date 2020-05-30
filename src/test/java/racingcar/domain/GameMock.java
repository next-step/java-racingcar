package racingcar.domain;

public class GameMock extends Game {

  private int attemptNum;

  private GameMock(Cars cars) {
    super(cars);
  }

  @Override
  public Cars doRace() {
    Cars cars = super.getCars();
    cars.move();
    attemptNum++;
    return cars;
  }

  public int getAttemptNum() {
    return attemptNum;
  }

  public static GameMock create(Cars cars) {
    return new GameMock(cars);
  }
}
