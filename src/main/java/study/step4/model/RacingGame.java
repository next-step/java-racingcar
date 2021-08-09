package study.step4.model;

import java.util.List;
import study.step4.model.car.Cars;
import study.step4.view.ResultView;

public class RacingGame {

  private final Cars cars;
  private final ResultView resultView;

  private final int racingGameRound;

  public RacingGame(int carNumber, int gameRound) {
    cars = Cars.of(carNumber);
    racingGameRound = gameRound;
    resultView = new ResultView(cars);
  }

  public RacingGame(String[] carNames, int gameRound) {
    cars = Cars.of(carNames);
    racingGameRound = gameRound;
    resultView = new ResultView(cars);
  }

  public void start() {
    ResultView resultView = new ResultView(cars);

    for (int i = 0; i < racingGameRound; i++) {
      cars.move();
      resultView.printResult();
    }
  }

  public Cars getCars() {
    return cars;
  }

  public int getRacingGameRound() {
    return racingGameRound;
  }
}
