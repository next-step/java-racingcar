package racingcar;

import racingcar.exception.OverFiveCarNameException;
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
		resultView.outputWinners(racingCars);
	}

	public static void main(String[] args) throws OverFiveCarNameException {
		InputView inputView = new InputView();
		RaceMain raceMain = new RaceMain();
		RacingCars racingCars = new RacingCars(inputView.inputCarNameList(), new RandomlyMovableStrategy());

		raceMain.startRace(inputView.inputTryCount(), racingCars);
		inputView.scannerClose();
	}
}
