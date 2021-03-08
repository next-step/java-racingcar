package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game {
	private List<Car> carList = new ArrayList<>();
	private int executeCount = 0;

	public Game(int carListSize) {
		makeCar(carListSize);
	}

	private void makeCar(int carListSize) {
		for (int i = 0; i < carListSize; i++) {
			carList.add(new Car());
		}
	}

	public List<Car> getCar() {
		return carList;
	}

	public void moveOrStop(Car car) {
		Random random = new Random();
		int randomNumber = random.nextInt(10);
		if (randomNumber >= 4) {
			car.move();
		}
	}

	public void run(int executeCount) {
		this.executeCount = 0;
		for (int i = 0; i < executeCount; i++) {
			execute();
			this.executeCount++;
		}
	}

	public int getExecuteCount() {
		return this.executeCount;
	}

	private void execute() {
		for (Car car: carList) {
			moveOrStop(car);
		}
	}
}
