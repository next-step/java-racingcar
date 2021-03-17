package racingCar;

import java.util.List;

public class RacingGameMain {

  public static void main(String[] args) {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    Referee referee = new Referee();

    String[] carNames = inputView.inputCarNames();
    int tryCount = inputView.inputTryCount();

    RacingGame racingGame = new RacingGame(carNames, tryCount);

    try {
      List<Car> winners = racingGame.start(outputView);
      outputView.printWinners(winners);
    } catch (OverCarNameLengthException e) {
      outputView.printError(e.getMessage());
    }
  }

}
