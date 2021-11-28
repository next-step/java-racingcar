package racingCar.controller;

import java.util.Arrays;
import java.util.stream.Collectors;
import racingCar.domain.RacingCar;
import racingCar.domain.RacingCars;
import racingCar.domain.Winners;
import racingCar.view.InputView;
import racingCar.view.ResultView;

public class RacingCarGame {

  private final InputView inputView;
  private final ResultView resultView;

  public RacingCarGame() {
    inputView = new InputView();
    resultView = new ResultView();
  }

  public void startWithUserInput() {
    race(inputView.inputTryCount());
  }

  public void race(int totalTryCount) {
    RacingCars racingCars = createCars();

    for (int tryCount = 0; tryCount < totalTryCount; tryCount++) {
      racingCars.moveAllCars();
      resultView.printAllCars(racingCars.getAllCars());
    }

    Winners winners = racingCars.findWinners();
    resultView.printWinner(winners.findWinnersName());
  }

  private RacingCars createCars() {
    String[] carNames = inputView.inputCarNames();

    return new RacingCars(
        Arrays.stream(carNames)
            .map(RacingCar::new)
            .collect(Collectors.toList())
    );
  }
}
