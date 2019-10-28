package step2;

import step2.domain.CarRaceCourse;
import step2.util.RandomGenerator;
import step2.view.InputView;
import step2.view.ResultView;

public class Main {

	public static void main(String[] args) {
		InputView inputView = new InputView();

		try {
			CarRaceCourse carRaceCourse =
					new CarRaceCourse(inputView.receiveNumberOfCarsParticipated(),
							inputView.receiveNumberOfMaxRound(), new RandomGenerator());
			proceedCarRaceUntilTheEnd(carRaceCourse);
		} catch (IllegalArgumentException e) {
			System.out.println(String.format("입력 값을 확인하세요! Error message: %s", e.getMessage()));
		}
	}

	private static void proceedCarRaceUntilTheEnd(CarRaceCourse carRaceCourse) {
		ResultView resultView = new ResultView();
		while (carRaceCourse.isNotEndRace()) {
			resultView.printVisualizedCarRacing(carRaceCourse.proceedOneRound());
		}
	}

}
