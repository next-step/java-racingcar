package racingcar.controller;

import racingcar.generator.Generator;
import racingcar.model.RacingGame;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class RacingController {
	private final Generator generator;

	public RacingController(Generator generator) {
		this.generator = generator;
	}

	public void startGame() {
		int numberOfRounds = InputView.scanNumberOfRounds();
		int numberOfCars = InputView.scanNumberOfCars();

		RacingGame racingGame = RacingGame.create(generator, numberOfRounds, numberOfCars);

		ResultView.printTitleAndWatingCars(racingGame);

		while (racingGame.hasNextRound()) {
			racingGame.moveOnce();
			ResultView.print(racingGame);
		}
	}
}
