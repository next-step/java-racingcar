package racingcar;

import racingcar.view.InputView;

public class RaceController {

	public void runRace() {
		String carInput = InputView.getCarInput();
		int roundInput = InputView.getRoundInput();
		InputView.closeScanner();

		RaceService raceService = new RaceService(carInput, roundInput);
		raceService.runRace();
	}
}
