package racingcar.manager;

import racingcar.model.Cars;
import racingcar.model.Winners;
import racingcar.ui.UIInGame;
import racingcar.ui.UIWinner;

import java.util.ArrayList;
import java.util.List;

public class GameManager {
	private Cars cars = new Cars();

	public void startGame() {
		int inputNum = UIManager.showIntro();
		if (inputNum == 1) {
			String[] carNames = UIManager.carNames();
			cars.createCars(carNames);
			runRound(UIManager.roundCount());
			Winners winners = new Winners();
			winners.findWinners(cars);
			UIWinner.printResult(winners.winners());
		}
		if (inputNum == 2) {
			System.exit(0);
		}
	}

	private void runRound(Integer roundCount) {
		for (int round = 1; round <= roundCount; round++) {
			race();
			UIInGame.printPosition(round, cars.cars());
		}
	}

	private void race() {
		for (int carNum = 1; carNum <= cars.size(); carNum++) {
			cars.car(carNum).move();
		}
	}
}
