package racingcar.manager;

import racingcar.model.Car;
import racingcar.ui.UIInGame;
import racingcar.util.RandomNumberGenerator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameManager {
	private UIManager uiManager = new UIManager();
	private Map<Integer, Car> carList = new HashMap<>();

	public void startGame() {
		int inputNum = uiManager.showIntro();
		if (inputNum == 1) {
			Integer carCount = uiManager.showCarCount();
			createCar(carCount);
			runRound(carCount, uiManager.showRoundCount());
		}
		if (inputNum == 2) {
			System.exit(0);
		}
	}

	private void createCar(Integer carCount) {
		for (int carNum = 1; carNum <= carCount; carNum++) {
			Car car = new Car(carNum);
			carList.put(carNum, car);
		}
	}

	private void runRound(Integer carCount, Integer roundCount) {
		RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
		for (int round = 1; round <= roundCount; round++) {
			for (int carNum = 1; carNum <= carCount; carNum++) {
				if (randomNumberGenerator.generate() >= 4) {
					carList.get(carNum).move();
				}
			}
			UIInGame.printPosition(round, carList);
		}
	}
}
