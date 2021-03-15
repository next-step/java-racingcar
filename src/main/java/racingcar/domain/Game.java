package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Game {
	private List<Car> carList = new ArrayList<>();
	private int executeCount = 0;
	private Random random = new Random();

	public Game(int carListSize) {
		this(new String[carListSize]);
	}

	public Game(String[] carNames) {
		makeCar(carNames);
	}

	public List<Car> getCar() {
		return Collections.unmodifiableList(carList);
	}

	public int getExecuteCount() {
		return this.executeCount;
	}

	public GameResult run(int executeCount) {
		GameResult gameResult = new GameResult();
		this.executeCount = 0;

		for (int i = 0; i < executeCount; i++) {
			gameResult.addResult(execute());
			this.executeCount++;
		}
		return gameResult;
	}

	private void makeCar(String[] carNames) {
		for (String carName : carNames) {
			carList.add(new Car(carName));
		}
	}

	private GameStatus execute() {
		GameStatus gameStatus = new GameStatus();
		for (Car car : carList) {
			car.moveOrStop(random.nextInt(10));
			gameStatus.add(car.copy(car));
		}
		return gameStatus;
	}

}
