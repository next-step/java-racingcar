package racingcar;

public class RacingGame {

  private Cars cars;

  public RacingGame(int numberOfCar) {
    initCars(numberOfCar);
  }

  private void initCars(int numberOfCar) {
    cars = new Cars(numberOfCar);
  }

  public void start(int numberOfTimes, Record record) {
    for (int i = 0; i < numberOfTimes; i++) {
      record.write(cars.moveCars());
    }
  }

}
