package racingcar.manager;

import racingcar.Main;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.ui.UIInGame;
import racingcar.ui.UIWinner;
import racingcar.util.Input;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameManager {
	private Cars cars = new Cars();

	public void startGame() {
		int inputNum = UIManager.showIntro();
		if (inputNum == 1) {
			String[] carNames = UIManager.carNames();
			cars.createCars(carNames);
			runRound(UIManager.roundCount());
			List<String> winners = winners();
			UIWinner.printResult(winners);
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

	private List<String> winners() {
		int maxDistance = 0;
		List<String> winners = new ArrayList<>();
		for (int carNum = 1; carNum <= cars.size(); carNum++) {
			if (cars.car(carNum).distance() == maxDistance) {
				winners.add(cars.car(carNum).name());
			}
			if (cars.car(carNum).distance() > maxDistance) {
				winners = new ArrayList<>();
				winners.add(cars.car(carNum).name());
				maxDistance = cars.car(carNum).distance();
			}
		}
		return winners;
	}
}
