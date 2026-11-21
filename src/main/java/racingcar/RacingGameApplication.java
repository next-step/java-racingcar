package racingcar;

import racingcar.car.Cars;
import racingcar.game.RacingGame;
import racingcar.generator.NumberGenerator;
import racingcar.generator.RandomNumberGenerator;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class RacingGameApplication {
	public static void main(String[] args) {
		InputView inputView = new InputView();
		ResultView resultView = new ResultView();
		NumberGenerator numberGenerator = new RandomNumberGenerator();

		String carList = inputView.inputCarNames();
		int racingRound = inputView.inputRacingRound();

		Cars cars = new Cars(carList);
		race(resultView, racingRound, cars, numberGenerator);
	}

	private static void race(ResultView resultView, int racingRound, Cars cars, NumberGenerator numberGenerator) {
		resultView.printResultTitle();
		RacingGame racingGame = new RacingGame(cars, racingRound);
		while (!racingGame.isFinished()) {
			racingGame.play(numberGenerator);
			resultView.printPositions(cars.getPositions());
		}
	}
}
