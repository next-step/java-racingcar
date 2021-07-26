package racingrefactoring;

import racingrefactoring.service.CarService;
import racingrefactoring.ui.InputView;
import racingrefactoring.ui.ResultView;

public class RacingApplication {

	private static final String RESULT_MESSAGE = "실행결과";

	public static void main(String[] args) {
		InputView inputView = new InputView();
		CarService racingGame = new CarService(inputView.getCarNames());

		System.out.println(RESULT_MESSAGE);
		for (int i = 0; i < inputView.getRepeatCount(); i++) {
			ResultView.result(racingGame.moveCars());
		}

		ResultView.printWinner(racingGame.winners());
	}

}
