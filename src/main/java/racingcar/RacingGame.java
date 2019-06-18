package racingcar;

public class RacingGame {

  private Cars cars;

  public RacingGame(String[] carNames) {
    initCars(carNames);
  }

  private void initCars(String[] carNames) {
    cars = new Cars(carNames);
  }

  public void start(int numberOfTimes, Record record) {
    for (int i = 0; i < numberOfTimes; i++) {
      record.write(cars.moveCars());
    }
  }

}
