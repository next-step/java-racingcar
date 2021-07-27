package racingcar;

import racingcar.model.RacingCars;
import racingcar.strategy.RandomlyMovableStrategy;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class RaceMain {
	public void startRace(int forwardCount, RacingCars racingCars) {
		ResultView resultView = new ResultView();
		resultView.outputStatement();
		for (int i = 0 ; i < forwardCount ; i++) {
			racingCars.forwardCars();
			resultView.outputResult(racingCars.getCars());
		}
	}

	public static void main(String[] args) {
		InputView inputView = new InputView();
		RaceMain raceMain = new RaceMain();
		RacingCars racingCars = new RacingCars(inputView.inputRacingCarNum(), new RandomlyMovableStrategy());

		raceMain.startRace(inputView.inputTryCount(), racingCars);
		inputView.scannerClose();
		
	}
}
