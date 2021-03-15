package racingCar;

import java.util.List;

public class RacingGameMain {

  public static void main(String[] args) {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    String[] carNames = inputView.inputCarNames();
    int tryCount = inputView.inputTryCount();

    RacingGame racingGame = new RacingGame(carNames, tryCount);

    try {
      List<Car> winners = racingGame.start(outputView);
    } catch (OverCarNameLengthException e) {
      outputView.printError(e.getMessage());
    }
  }

}
