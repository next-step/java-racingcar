package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game {
	private List<Car> carList = new ArrayList<>();
	private int executeCount = 0;
	private Random random = new Random();

	public Game(int carListSize) {
		makeCar(carListSize);
	}

	public Game(String[] carNames) {
		makeCar(carNames);
	}

	public List<Car> getCar() {
		return carList;
	}

	public int getExecuteCount() {
		return this.executeCount;
	}

	public GameResult run(int executeCount) {
		GameResult gameResult = new GameResult();
		this.executeCount = 0;

		for (int i = 0; i < executeCount; i++) {
			execute(gameResult);
			this.executeCount++;
		}
		return gameResult;
	}

	private void makeCar(int carListSize) {
		for (int i = 0; i < carListSize; i++) {
			carList.add(new Car());
		}
	}

	private void makeCar(String[] carNames) {
		for (String carName : carNames) {
			carList.add(new Car(carName));
		}
	}

	private void execute(GameResult gameResult) {
		GameStatus gameStatus = new GameStatus();
		for (Car car : carList) {
			car.moveOrStop(random.nextInt(10));
			gameStatus.add((Car)car.clone());
		}
		gameResult.addResult(gameStatus);
	}

}
