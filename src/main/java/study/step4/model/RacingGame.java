package study.step4.model;

import study.step4.model.car.Cars;
import study.step4.model.strategy.MoveStrategy;
import study.step4.view.ResultView;

public class RacingGame {

  private final Cars cars;

  private final int racingGameRound;

  public RacingGame(int carNumber, int gameRound) {
    cars = Cars.of(carNumber);
    racingGameRound = gameRound;
  }

  public RacingGame(String carNames, int gameRound) {
    cars = Cars.of(carNames);
    racingGameRound = gameRound;
  }

  public void start(MoveStrategy moveStrategy, ResultView resultView) {
    for (int i = 0; i < racingGameRound; i++) {
      cars.move(moveStrategy);
      printGameResult(cars, resultView);
    }

    resultView.printWinner(cars.getWinners());
  }

  private void printGameResult(Cars cars, ResultView resultView) {
    for (int i = 0; i < cars.getRacingGameCarsCount(); i++) {
      resultView.printResult(cars.getCar(i).getName(), cars.getCar(i).getDistance());
    }
    System.out.println();
  }

  public Cars getCars() {
    return cars;
  }

  public int getRacingGameRound() {
    return racingGameRound;
  }
}
