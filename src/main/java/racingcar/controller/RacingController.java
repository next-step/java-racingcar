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

	public void startGame() {
		int numberOfRounds = InputView.scanNumberOfRounds();
		int numberOfCars = InputView.scanNumberOfCars();

		RacingGame racingGame = RacingGame.create(moveRule, numberOfRounds, numberOfCars);

		ResultView.printTitleAndWatingCars(racingGame);

		while (racingGame.hasNextRound()) {
			racingGame.moveOnce();
			ResultView.print(racingGame);
		}
	}
}
