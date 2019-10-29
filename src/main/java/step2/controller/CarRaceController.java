package step2.controller;

import step2.domain.CarRaceCourse;
import step2.domain.rules.CarNameRule;
import step2.domain.rules.RaceRoundRule;
import step2.util.RandomGenerator;
import step2.view.InputView;
import step2.view.ResultView;

public class CarRaceController {

	private CarRaceCourse carRaceCourse;

	public CarRaceController() {
		InputView inputView = new InputView();
		try {
			CarNameRule carNameRule = inputView.receiveNameOfCarsParticipated();
			RaceRoundRule raceRoundRule = inputView.receiveNumberOfMaxRound();
			carRaceCourse = new CarRaceCourse(carNameRule, raceRoundRule, new RandomGenerator());
		} catch (IllegalArgumentException e) {
			System.out.println(String.format("입력 값을 확인하세요! Error message: %s", e.getMessage()));
		}
	}

	public void proceedRaceUtilTheEnd() {
		ResultView resultView = new ResultView();
		while (carRaceCourse.isNotEndRace()) {
			resultView.printVisualizedCarRacing(carRaceCourse.proceedOneRound());
		}
		resultView.printFinalResult(carRaceCourse.getResult());
	}

}
