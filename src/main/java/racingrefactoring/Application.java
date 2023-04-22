package racingrefactoring;

import racingrefactoring.domain.CarGroup;
import racingrefactoring.domain.MoveStrategy;
import racingrefactoring.domain.RacingCarGame;
import racingrefactoring.domain.RandomMoveStrategy;
import racingrefactoring.view.InputView;
import racingrefactoring.view.OutputView;

public class Application {

  public static void main(String[] args) {
    CarGroup carGroup = initCarGroup();
    carGroup = playGames(carGroup, new RandomMoveStrategy());
    OutputView.printWinners(carGroup.findWinners());
  }

  private static CarGroup initCarGroup() {
    String carNames = InputView.scanCarNames();

    return new CarGroup(carNames);
  }

  private static CarGroup playGames(CarGroup carGroup, MoveStrategy moveStrategy) {
    RacingCarGame racingCarGame = new RacingCarGame(carGroup);

    int round = InputView.scanRound();

    OutputView.printEmptyLine();
    OutputView.printResultMessage();
    for (int i = 0; i < round; i++) {
      carGroup = racingCarGame.play(moveStrategy);
      OutputView.printCarGroup(carGroup);
      OutputView.printEmptyLine();
    }
    return carGroup;
  }

}
