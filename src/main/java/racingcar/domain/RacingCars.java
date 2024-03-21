package racingcar.domain;

import java.util.List;
import java.util.Random;

public class RacingCars {
	Random random = new Random();
	public void moveCars(List<Car> carList) {
		for (Car car : carList) {
			int randomNum = random.nextInt(10);
			car.moveForward(randomNum);
		}
	}

	public void addCarsToList(List<Car> carList, int carNumber) {
		for (int i = 0; i < carNumber; i++) {
			Car car = new Car();
			carList.add(car);
		}
	}
}
