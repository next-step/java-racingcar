package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Cars {
	private List<Car> cars;

	public Cars(int carCount) {
		this.cars = new ArrayList<>();
		for(int i = 0; i < carCount; i++) {
			cars.add(new Car());
		}
	}

	public void move() {
		int moveResult;
		for (Car car : this.cars) {
			moveResult = car.tryMove(RandomNumberGenerator.createRandomNumber());
			ResultView.printMove(moveResult);
		}
	}

	public int sizeOfCars() {
		return this.cars.size();
	}
}
