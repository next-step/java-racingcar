package racingCar;

import java.util.ArrayList;
import view.InputView;
import view.ResultView;

public class RacingCarGame {

  private InputView inputView;
  private ResultView resultView;
  private RacingCars racingCars;

  public RacingCarGame() {
    racingCars = new RacingCars(new ArrayList<>());
    inputView = new InputView();
    resultView = new ResultView();
  }

  public void startWithUserInput() {
    createCars(inputView.inputCarNames());
    race(inputView.inputTryCount());
  }

  private void createCars(String[] carNames) {
    for (String carName : carNames) {
      racingCars.add(new RacingCar(0, carName));
    }
  }

  public void race(int totalTryCount) {
    for (int tryCount = 0; tryCount < totalTryCount; tryCount++) {
      racingCars.moveAllCars();
      resultView.printAllCars(racingCars.getAllCars());
    }
    resultView.printWinner(racingCars.getWinnerNames());
  }
}
