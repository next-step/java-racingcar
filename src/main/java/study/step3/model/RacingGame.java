package study.step3.model;

import study.step3.model.car.Cars;

public class RacingGame {

  private Cars cars;

  private int racingGameRound;

  public RacingGame(int carNumber, int gameRound) {
    cars = new Cars(carNumber);
    racingGameRound = gameRound;
  }

  public void start() {
    for(int i=0; i<racingGameRound; i++) {
      cars.move();
      cars.printResult();
    }
  }

  public Cars getCars() {
    return cars;
  }

  public int getRacingGameRound() {
    return racingGameRound;
  }
}
