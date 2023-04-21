package racingrefactoring.controller;

import racingrefactoring.domain.CarGroup;
import racingrefactoring.domain.MoveStrategy;
import racingrefactoring.domain.RacingCarGame;
import racingrefactoring.view.InputView;
import racingrefactoring.view.OutputView;

public class RacingCarController {

  private final MoveStrategy moveStrategy;

  public RacingCarController(MoveStrategy moveStrategy) {
    this.moveStrategy = moveStrategy;
  }

  public void startGame() {
    CarGroup carGroup = initCarGroup();
    carGroup = playGames(carGroup, moveStrategy);
    OutputView.printWinners(carGroup.findWinners());
  }

  private static CarGroup playGames(CarGroup carGroup, MoveStrategy moveStrategy) {
    RacingCarGame racingCarGame = new RacingCarGame(carGroup);

    int round = InputView.scanRound();

    OutputView.printEmptyLine();
    OutputView.printResultMessage();
    for (int i = 0; i <round; i++) {
      carGroup = racingCarGame.play(moveStrategy);
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
