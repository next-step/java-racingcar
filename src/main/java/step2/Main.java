package step2;

import step2.view.InputView;
import step2.view.ResultView;

public class Main {

	public static void main(String[] args) {
		InputView inputView = new InputView();
		ResultView resultView = new ResultView();

		CarRaceCourse carRaceCourse =
				new CarRaceCourse(inputView.receiveNumberOfCarsParticipated(), inputView.receiveNumberOfMaxRound());

		while (carRaceCourse.isNotEndRace()) {
			carRaceCourse.proceedOneRound();
			resultView.printVisualizedCarRacing(carRaceCourse.observeRaceSnapShot());
		}
	}

}
