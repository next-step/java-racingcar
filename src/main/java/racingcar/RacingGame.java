package racingcar;

import racingcar.car.Cars;
import racingcar.generator.NumberGenerator;
import racingcar.generator.RandomNumberGenerator;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class RacingGame {
	public static void main(String[] args) {
		InputView inputView = new InputView();
		ResultView resultView = new ResultView();
		NumberGenerator numberGenerator = new RandomNumberGenerator();

		int carNumber = inputView.inputCarNumber();
		int racingRound = inputView.inputRacingRound();

		Cars cars = new Cars(carNumber);
		resultView.printResultTitle();

		for (int i = 0; i < racingRound; i++) {
			cars.play(numberGenerator);
			resultView.printPositions(cars.getPositions());
		}

	}
}
