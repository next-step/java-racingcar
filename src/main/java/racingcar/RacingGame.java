package racingcar;

public class RacingGame {

  private Initializerer initializerer;
  private Cars cars;
  private Position position = new Position();

  public RacingGame(Initializerer initializerer) {
    this.initializerer = initializerer;
    initCars();
  }

  private void initCars() {
    cars = new Cars(initializerer.getNumberOfCar());
  }

  public void start() {
    for (int i = 0; i < initializerer.getNumberOfTimes(); i++) {
      cars.move();
      record();
    }
  }

  private void record() {
    position.add(cars.getCarsPosition());
  }

  public Position result() {
    return position;
  }
}
