package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game {
	List<Car> carList = new ArrayList<>();

	public void makeCar(int carListSize) {
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
}
