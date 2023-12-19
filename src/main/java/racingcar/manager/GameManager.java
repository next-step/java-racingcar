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

public class GameManager {
	private Map<Integer, Car> carList = new HashMap<>();

	public void startGame() {
		int inputNum = UIManager.showIntro();
		if (inputNum == 1) {
			String[] carNames = UIManager.carNames();
			createCar(carNames);
			runRound(UIManager.roundCount());
			List<String> winners = winners();
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

	private void runRound(Integer roundCount) {
		for (int round = 1; round <= roundCount; round++) {
			race();
			UIInGame.printPosition(round, carList);
		}
	}

	private void race() {
		for (int carNum = 1; carNum <= carList.size(); carNum++) {
			carList.get(carNum).move();
		}
	}

	private List<String> winners() {
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
