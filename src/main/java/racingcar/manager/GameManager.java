package racingcar.manager;

import racingcar.Main;
import racingcar.model.Car;
import racingcar.ui.UIInGame;
import racingcar.util.Input;
import racingcar.util.RandomNumberGenerator;

import java.util.HashMap;
import java.util.Map;

public class GameManager {
	private Map<Integer, Car> carList = new HashMap<>();

	public void startGame() {
		int inputNum = UIManager.showIntro();
		if (inputNum == 1) {
			String[] carNames = UIManager.showCarNames();
			createCar(carNames);
			runRound(carNames.length, UIManager.showRoundCount());
		}
		if (inputNum == 2) {
			System.exit(0);
		}
	}

	private void createCar(String[] carNames) {
		for (int carNum = 1; carNum <= carNames.length; carNum++) {
			limitNameLegth(carNames, carNum);
			Input.validateInput(carNames[carNum - 1]);
			Car car = new Car(carNames[carNum - 1].trim());
			carList.put(carNum, car);
		}
	}

	private void limitNameLegth(String[] carNames, Integer carNum) {
		if (carNames[carNum - 1].trim().length() > 5) {
			String[] args = new String[0];
			Main.main(args);
		}
	}

	private void runRound(Integer carCount, Integer roundCount) {
		for (int round = 1; round <= roundCount; round++) {
			for (int carNum = 1; carNum <= carCount; carNum++) {
				if (RandomNumberGenerator.generate() >= 4) {
					carList.get(carNum).move();
				}
			}
			UIInGame.printPosition(round, carList);
		}
	}
}
