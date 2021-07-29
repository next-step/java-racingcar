package refactoring;

import refactoring.domain.RacingGame;
import refactoring.view.InputView;
import refactoring.view.ResultView;

public class RacingMain {

	public static void main(String[] args) {

		String carNames = InputView.inputCarNames();
		int tryCount = InputView.inputTryCount();

		RacingGame racingGame = new RacingGame(carNames);

		while (tryCount-- > 0) {
			racingGame.move();
			ResultView.printRacingRecords(racingGame.getRecords());
		}

		ResultView.printRacingResult(racingGame.getWinnerResults());
	}
}
