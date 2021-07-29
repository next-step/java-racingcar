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
		Racing racing = Racing.raceStart(carsName,roundCount);
		racingOutputView.racingStartView();
		racingOutputView.racingResultView(racing.carsRaceForResult());
		racingOutputView.racingWinnerView(racing.winnerPlayer());
	}

}
