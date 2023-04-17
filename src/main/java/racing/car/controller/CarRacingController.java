package racing.car.controller;

import racing.car.domain.CarRacing;
import racing.car.view.InputView;
import racing.car.view.ResultView;

public class CarRacingController {

	private final InputView inputView;
	private final ResultView resultView;
	private CarRacing carRacing;

	public CarRacingController(InputView inputView, ResultView resultView, CarRacing carRacing) {
		this.inputView = inputView;
		this.resultView = resultView;
		this.carRacing = carRacing;
	}

	public void run() {
		String carNames = this.inputView.inputCarNames();
		int tryCount = this.inputView.inputTryCount();

		this.carRacing = new CarRacing(carNames);

		resultView.printStartLineText();
		while (tryCount-- > 0) {
			carRacing.race();
			resultView.printStatus(carRacing.getCars());
		}

		resultView.printWinners(carRacing.findWinners());
	}
}
