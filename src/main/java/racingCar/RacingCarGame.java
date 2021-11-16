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
    createCars(inputView.inputCarCount());
    race(inputView.inputTryCount());
  }

  private void createCars(int carCount) {
    for (int i = 0; i < carCount; i++) {
      racingCars.add(new RacingCar(0));
    }
  }

  public void race(int tryCount) {
    for (int currentMoveCount = 0; currentMoveCount < tryCount; currentMoveCount++) {
      racingCars.moveAllCars();
      resultView.printAllCars(racingCars.getAllCarsMoveCount());
    }
  }
}
