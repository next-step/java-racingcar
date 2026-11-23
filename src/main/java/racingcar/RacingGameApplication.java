package racingcar;

import racingcar.domain.game.RacingGame;
import racingcar.domain.generator.NumberGenerator;
import racingcar.domain.generator.RandomNumberGenerator;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class RacingGameApplication {
	public static void main(String[] args) {
		InputView inputView = new InputView();
		ResultView resultView = new ResultView();
		NumberGenerator numberGenerator = new RandomNumberGenerator();

		String carNames = inputView.inputCarNames();
		int racingRound = inputView.inputRacingRound();

		race(resultView, carNames, racingRound, numberGenerator);
	}

	private static void race(ResultView resultView, String carNames, int racingRound, NumberGenerator numberGenerator) {
		resultView.printResultTitle();
		RacingGame racingGame = new RacingGame(carNames, racingRound);
		while (!racingGame.isFinished()) {
			racingGame.play(numberGenerator);
			resultView.printCars(racingGame.getCars());
		}
		resultView.printWinners(racingGame.findWinners());
	}
}
