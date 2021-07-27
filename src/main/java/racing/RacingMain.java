package racing;

import java.util.List;

import racing.controller.RacingController;
import racing.view.InputView;

public class RacingMain {

	public static void main(String[] args) {
		List<String> names = InputView.inputCarNames();
		int tryCount = InputView.inputTryCount();

		RacingController.start(names, tryCount);
	}
}
