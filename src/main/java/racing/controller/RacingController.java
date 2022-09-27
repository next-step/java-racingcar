package racing.controller;

import racing.model.Racing;
import racing.view.InputView;
import racing.view.OutputView;

public class RacingController {

	public void run() {
		int carCount = InputView.inputCarCount();
		int times = InputView.inputTimes();
		playGame(times, new Racing(carCount));
	}

	private void playGame(int times, Racing racing) {
		OutputView.printResultMessage();
		for (int i = 0; i < times; i++) {
			racing.race();
			OutputView.printCarsPosition(racing.getCars());
		}
	}
}
