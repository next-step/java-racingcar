package racingcar;

public class RacingGame {

  private Cars cars;
  private Record record = new Record();


  public RacingGame(int numberOfCar) {
    initCars(numberOfCar);
  }

  private void initCars(int numberOfCar) {
    cars = new Cars(numberOfCar);
  }

  public void start(int numberOfTimes) {
    for (int i = 0; i < numberOfTimes; i++) {
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
