package racingcar.controller;

import racingcar.exception.NameValidationException;
import racingcar.model.RacingCars;
import racingcar.strategy.RandomlyMovableStrategy;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class RaceController {
	public void startRace(int forwardCount, RacingCars racingCars) {
		ResultView resultView = new ResultView();
		resultView.outputStatement();
		for (int i = 0 ; i < forwardCount ; i++) {
			racingCars.forwardCars();
			resultView.outputResult(racingCars.getCars());
		}
		resultView.outputWinners(racingCars);
	}

	public static void main(String[] args) throws NameValidationException {
		InputView inputView = new InputView();
		RaceController raceController = new RaceController();
		RacingCars racingCars = new RacingCars(inputView.inputCarNames(), new RandomlyMovableStrategy());

		raceController.startRace(inputView.inputTryCount(), racingCars);
		inputView.scannerClose();
	}
}
