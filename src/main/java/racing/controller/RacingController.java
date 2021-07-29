package racing.controller;

import racing.domain.Racing;
import racing.view.RacingInputView;
import racing.view.RacingOutputView;

public class RacingController {

	public static void main(String[] args) {
		RacingInputView racingInputView = new RacingInputView();
		String carsName = racingInputView.firstRequestView();
		int roundCount = racingInputView.secondRequestView();

		RacingOutputView racingOutputView = new RacingOutputView();
		Racing racing = Racing.raceStart(carsName);
		racingOutputView.racingStartView();
		for (int i = 0; i < roundCount; i++) {
			racingOutputView.racingResultView(racing.carsRaceForResult());
		}
		racingOutputView.racingWinnerView(racing.winnerPlayer());
	}

}
