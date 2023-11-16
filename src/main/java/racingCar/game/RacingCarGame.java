package racingCar.game;

import racingCar.car.Cars;
import racingCar.car.Winners;
import racingCar.ui.InputView;
import racingCar.ui.ResultView;

public class RacingCarGame { // 자동차 경주를 수행한다.
	private final InputView inputView;
	private final ResultView resultView;

	public RacingCarGame(InputView inputView, ResultView resultView) {
		this.inputView = inputView;
		this.resultView = resultView;
	}

	public void run() {
		RacingGameRequest racingGameRequest = inputView.gameRequestWithNames();

		resultView.printPrefix();

		Cars cars = Cars.of(racingGameRequest.carNames());
		cars.setCallBack(new Cars.CallBack() {
			@Override
			public void printCallBack(Cars cars) {
				resultView.printDistanceWithName(cars);
			}
		});

		cars.moveByTryCount(racingGameRequest.tryCount());

		Winners winners = new Winners(cars);
		resultView.printWinner(winners);
	}
}
