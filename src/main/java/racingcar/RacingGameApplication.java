package racingcar;

import racingcar.domain.car.Cars;
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

		Cars cars = new Cars(carNames);
		race(resultView, racingRound, cars, numberGenerator);
	}

	private static void race(ResultView resultView, int racingRound, Cars cars, NumberGenerator numberGenerator) {
		resultView.printResultTitle();
		RacingGame racingGame = new RacingGame(cars, racingRound);
		while (!racingGame.isFinished()) {
			racingGame.play(numberGenerator);
			resultView.printCars(cars.getCars());
		}
		resultView.printWinners(cars.findWinners());
	}
}
