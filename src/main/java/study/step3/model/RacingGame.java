package study.step3.model;

import study.step3.model.car.Cars;
import study.step3.view.ResultView;

public class RacingGame {

  private Cars cars;
  private ResultView resultView;

  private int racingGameRound;

  public RacingGame(int carNumber, int gameRound) {
    cars = new Cars(carNumber);
    racingGameRound = gameRound;
    resultView = new ResultView();
  }

  public void start() {
    for(int i=0; i<racingGameRound; i++) {
      cars.move();
      resultView.printResult(cars.getRacingGameCars());
    }
  }

  public Cars getCars() {
    return cars;
  }

  public int getRacingGameRound() {
    return racingGameRound;
  }
}
