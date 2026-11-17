package racingcar;

import racingcar.car.Cars;
import racingcar.generator.RandomNumberGenerator;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class RacingGame {
	public static void main(String[] args) {
		InputView inputView = new InputView();
		ResultView resultView = new ResultView();

		int carNumber = inputView.inputCarNumber();
		int racingRound = inputView.inputRacingRound();

		Cars cars = new Cars(carNumber);
		System.out.println("실행결과");

		for (int i = 0; i < racingRound; i++) {
			cars.play(new RandomNumberGenerator());
			resultView.view(cars.getPositions());
		}

	}
}
