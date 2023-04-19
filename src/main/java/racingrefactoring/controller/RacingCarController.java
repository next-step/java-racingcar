package racingrefactoring.controller;

import racingrefactoring.domain.CarGroup;
import racingrefactoring.domain.RacingGame;
import racingrefactoring.domain.RandomMoveStrategy;
import racingrefactoring.view.InputView;
import racingrefactoring.view.OutputView;

public class RacingCarController {

  public void startGame() {
    CarGroup carGroup = initCarGroup();
    carGroup = playGames(carGroup);
    OutputView.printWinners(carGroup.findWinners());
  }

  private static CarGroup playGames(CarGroup carGroup) {
    RacingGame racingGame = new RacingGame(carGroup);

    int round = InputView.scanRound();

    OutputView.printEmptyLine();
    OutputView.printResultMessage();
    for (int i = 0; i <round; i++) {
      carGroup = racingGame.play(new RandomMoveStrategy());
      OutputView.printCarGroup(carGroup);
      OutputView.printEmptyLine();
    }
    return carGroup;
  }

  private static CarGroup initCarGroup() {
    String carNames = InputView.scanCarNames();

    return new CarGroup(carNames);
  }
}
