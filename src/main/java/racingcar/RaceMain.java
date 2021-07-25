package racingcar;

import racingcar.model.RacingCars;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class RaceMain {
	private static InputView inputView = new InputView();
	private static ResultView resultView = new ResultView();

	public void startRace(int forwardCount, RacingCars racingCars) {
		System.out.println("\n실행결과");
		for (int i = 0 ; i < forwardCount ; i++) {
			racingCars.forwardCars();
			resultView.outputResult(racingCars.getCars());
		}
	}

	public static void main(String[] args) {
		RaceMain raceMain = new RaceMain();
		RacingCars racingCars = new RacingCars(inputView.inputRacingCarNum());
		raceMain.startRace(inputView.inputTryCount(), racingCars);
		inputView.scannerClose();
	}
}
