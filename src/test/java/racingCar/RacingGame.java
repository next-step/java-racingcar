package racingCar;

public class RacingGame {

  private int tryCount;

  public RacingGame(int tryCount) {
    this.tryCount = tryCount;
  }

  public void start() {
    Car car = new Car();
    for (int i=0 ; i < tryCount ; i++) {
      car.move(RandomNumber.create());
    }
  }


}
