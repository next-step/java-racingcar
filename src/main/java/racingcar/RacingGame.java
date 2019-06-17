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
      cars.move(i);
    }
  }

  public Position result() {
    for (int i = 0; i < initializerer.getNumberOfTimes(); i++) {
      position.add(cars.getCarsPosition(i));
    }
    return position;
  }
}
