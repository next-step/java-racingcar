package racing.controller;

import racing.domain.Racing;
import racing.view.ResultView;

public class RacingController {

	public void start(int carCount, int tryCount) {
		Racing racing = new Racing(carCount);

		for (int i = 0; i < tryCount; i++) {
			ResultView.printRacingResult(racing.move());
		}
	}
}
