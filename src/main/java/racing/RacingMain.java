package racing;

import racing.controller.RacingController;
import racing.view.InputView;

public class RacingMain {

	public static void main(String[] args) {
		String[] names = InputView.inputCarNames();
		int tryCount = InputView.inputTryCount();

		RacingController.start(carCount, tryCount);
	}
}
