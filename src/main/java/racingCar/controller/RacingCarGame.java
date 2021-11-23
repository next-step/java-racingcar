package racingCar.controller;

import java.util.Arrays;
import java.util.stream.Collectors;
import racingCar.model.RacingCar;
import racingCar.model.RacingCars;
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

  private RacingCars createCars() {
    String[] carNames = inputView.inputCarNames();

    return new RacingCars(
        Arrays.stream(carNames)
            .map(RacingCar::new)
            .collect(Collectors.toList())
    );
  }

  public void race(int totalTryCount) {
    RacingCars racingCars = createCars();

    for (int tryCount = 0; tryCount < totalTryCount; tryCount++) {
      racingCars.moveAllCars();
      resultView.printAllCars(racingCars.getAllCars());
    }

    resultView.printWinner(racingCars.determineWinners());
  }
}
