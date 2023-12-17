package racingcar.manager;

import racingcar.Main;
import racingcar.model.Car;
import racingcar.ui.UIInGame;
import racingcar.ui.UIWinner;
import racingcar.util.Input;
import racingcar.util.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class GameManager {
	private Map<Integer, Car> carList = new HashMap<>();

	public void startGame() {
		int inputNum = UIManager.showIntro();
		if (inputNum == 1) {
			String[] carNames = UIManager.showCarNames();
			createCar(carNames);
			runRound(carNames.length, UIManager.showRoundCount());
			List<String> winners = findWinner();
			UIWinner.printResult(winners);
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

	private List<String> findWinner() {
		int maxDistance = 0;
		List<String> winners = new ArrayList<>();
		for (int carNum = 1; carNum <= carList.size(); carNum++) {
			if (carList.get(carNum).getDistance() == maxDistance) {
				winners.add(carList.get(carNum).getName());
			}
			if (carList.get(carNum).getDistance() > maxDistance) {
				winners = new ArrayList<>();
				winners.add(carList.get(carNum).getName());
				maxDistance = carList.get(carNum).getDistance();
			}
		}
		return winners;
	}
}
