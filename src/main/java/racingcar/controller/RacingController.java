package racingcar.controller;

import racingcar.model.RacingGame;
import racingcar.rule.MoveRule;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class RacingController {
	private final MoveRule moveRule;

	public RacingController(MoveRule moveRule) {
		this.moveRule = moveRule;
	}

	public void startGameWithName() {
		String nameOfCars = InputView.scanNameOfCars();
		int numberOfRounds = InputView.scanNumberOfRounds();

		RacingGame racingGame = RacingGame.create(moveRule, nameOfCars, numberOfRounds);

		ResultView.printTitleAndWaitingCars(racingGame);

		while (racingGame.hasNextRound()) {
			racingGame.moveOnce();
			ResultView.print(racingGame);
		}

		ResultView.printWinners(racingGame);
	}
}
