package racingcar;

import java.util.Scanner;

import racingcar.domain.RacingCars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarMain {
	public static void main(String[] args) {
		InputView input = new InputView();
		String carNames = input.setCarNames();
		int trialNumber = input.setTrialNumber();

		RacingCars racingCars = new RacingCars(carNames);
		racingCars.conductCarRacing(trialNumber);
		racingCars.getWinners();
	}
}
