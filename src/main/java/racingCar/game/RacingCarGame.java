package racingCar.game;

import racingCar.car.Cars;
import racingCar.car.Winners;
import racingCar.ui.InputView;
import racingCar.ui.ResultView;

public class RacingCarGame { // 자동차 경주를 수행한다.
	private final InputView inputView;
	private final ResultView resultView;
	private RacingGameRequest racingGameRequest;
	private Cars cars;

	public RacingCarGame(InputView inputView, ResultView resultView) {
		this.inputView = inputView;
		this.resultView = resultView;
	}

	public void run() {
		racingGameRequest = inputView.gameRequestWithNames();

		resultView.printPrefix();

		cars = new Cars(racingGameRequest.cars());
		moveByTryCount();

		Winners winners = new Winners(cars);
		resultView.printWinner(winners);
	}

	private void moveByTryCount() {
		for (int i = 0; i < racingGameRequest.tryCount(); i++) {
			cars.moveOnce();
			resultView.printDistanceWithName(cars);
		}
	}
}
