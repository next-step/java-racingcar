package racingcar;

public class RaceController {

	public void runRace() {
		int carInput = InputView.getCarInput();
		int roundInput = InputView.getRoundInput();
		InputView.closeScanner();

		RaceService raceService = new RaceService(carInput, roundInput);
		raceService.runRace();
	}
}
