package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game {
	private List<Car> carList = new ArrayList<>();
	private List<String> winners = new ArrayList<>();
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

	public void run(int executeCount) {
		ResultView resultView = new ResultView();
		resultView.printHead();
		this.executeCount = 0;

		for (int i = 0; i < executeCount; i++) {
			execute(resultView);
			this.executeCount++;
		}
		resultView.printTail(getWinners(carList));
	}

	public List<String> getWinners(List<Car> carList) {
		int maxPosition = 0;

		for (Car car : carList) {
			maxPosition = camparePosition(car, maxPosition);
		}

		return winners;
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

	private void execute(ResultView resultView) {
		for (Car car : carList) {
			car.moveOrStop(random.nextInt(10));
			resultView.printPosition(car);
		}
		resultView.printEmptyLine();

	}

	private int camparePosition(Car car, int maxPosition) {
		int carPosition = car.getPosition();
		String carName = car.getCarName();
		if (carPosition == maxPosition) {
			winners.add(carName);
		}
		if (carPosition > maxPosition) {
			winners.clear();
			winners.add(carName);
			maxPosition = carPosition;
		}
		return maxPosition;
	}
}
