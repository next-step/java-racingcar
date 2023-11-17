package racingCar.controller;

import racingCar.domain.RacingGameRequest;
import racingCar.domain.Cars;
import racingCar.domain.Winners;
import racingCar.view.InputView;
import racingCar.view.ResultView;

public class RacingCarGame { // 자동차 경주를 수행한다.
	private final InputView inputView;
	private final ResultView resultView;
	private Callback callBack;

	public interface Callback {
		void printCallBack(Cars cars);
	}

	public RacingCarGame(InputView inputView, ResultView resultView) {
		this.inputView = inputView;
		this.resultView = resultView;
		this.callBack = null;
	}

	public void setCallBack(Callback callBack) {
		this.callBack = callBack;
	}

	public void run() {
		RacingGameRequest racingGameRequest = inputView.gameRequestWithNames();

		resultView.printPrefix();

		Cars cars = Cars.of(racingGameRequest.carNames());
		this.setCallBack(new Callback() {
			@Override
			public void printCallBack(Cars cars) {
				resultView.printDistanceWithName(cars);
			}
		});

		cars.moveByTryCount(racingGameRequest.tryCount(), this.callBack);

		Winners winners = new Winners(cars);
		resultView.printWinner(winners);
	}
}
