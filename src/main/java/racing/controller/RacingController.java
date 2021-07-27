package racing.controller;

import racing.domain.Racing;
import racing.view.ResultView;

public class RacingController {

	public static void start(String[] names, int tryCount) {
		Racing racing = new Racing(names);

		for (int i = 0; i < tryCount; i++) {
			ResultView.printRacingResult(racing.move());
		}

		ResultView.printRacingWinnerResult(racing.getTopRankResult());
	}
}
