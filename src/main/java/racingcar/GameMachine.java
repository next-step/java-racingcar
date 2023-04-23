package racingcar;

import racingcar.application.Car;
import racingcar.application.Cars;
import racingcar.application.RandomAccelerator;
import racingcar.application.RandomMoveStrategy;
import racingcar.application.ScoreBoard;
import racingcar.dto.CarNames;
import racingcar.ui.InputView;
import racingcar.ui.ResultView;

public class GameMachine {
  private final InputView inputView = new InputView();
  private final ResultView resultView = new ResultView();
  private final ScoreBoard scoreBoard = new ScoreBoard();

  public void play() {
    CarNames carNames = inputView.askCarNames();
    int trialNumber = inputView.askTrialNumbers().trialNumber();

    Cars cars = Cars.readyForRace(new RandomMoveStrategy(new RandomAccelerator()), carNames);

    resultView.printResultAlert();

    mainGame(cars, trialNumber);

    resultView.printWinner(scoreBoard);
  }

  private void mainGame(Cars cars, int trialNumber) {
    for (int i = 0; i < trialNumber; i++) {
      cars.go();
      scoreBoard.record(cars);
      resultView.printLocations(cars);
    }
  }
}
