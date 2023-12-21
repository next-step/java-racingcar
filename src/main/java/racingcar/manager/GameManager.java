package racingcar.manager;

import racingcar.controller.RacingGame;
import racingcar.model.Cars;
import racingcar.model.Winners;
import racingcar.ui.UIWinner;

public final class GameManager {
	private final Cars cars = new Cars();

	public void startGame() {
		int inputNum = UIManager.showIntro();
		if (inputNum == 1) {
			RacingGame.runRound(cars.createCars(UIManager.carNames()), UIManager.roundCount());
			UIWinner.printResult(Winners.findWinners(cars.cars()));
		}
		if (inputNum == 2) {
			System.exit(0);
		}
	}
}
