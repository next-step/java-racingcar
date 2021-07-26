package racing;

import racing.controller.RacingController;
import racing.view.InputView;

public class RacingMain {

	public static void main(String[] args) {
		int carCount = InputView.inputCarCount();
		int tryCount = InputView.inputTryCount();

		RacingController.start(carCount, tryCount);
	}
}
