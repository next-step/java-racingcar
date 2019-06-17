package racingcar;

public class RacingGame {

  private Initializerer initializerer;
  private Cars cars;
  private Record record = new Record();


  public RacingGame(Initializerer initializerer) {
    this.initializerer = initializerer;
    initCars();
  }

  private void initCars() {
    cars = new Cars(initializerer.getNumberOfCar());
  }

  public void start() {
    for (int i = 0; i < initializerer.getNumberOfTimes(); i++) {
      cars.moveCars();
      record();
    }
  }

  private void record() {
    record.write(cars.position());
  }

  public Record result() {
    return record;
  }
}
