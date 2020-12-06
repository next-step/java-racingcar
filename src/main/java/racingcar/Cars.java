package racingcar;

import java.util.List;

public class Cars {
	private List<Car> cars;

	public Cars(List<Car> cars) {
		this.cars = cars;
	}

	public void moveCars() {
		int moveResult;
		for (Car car : this.cars) {
			moveResult = car.tryMove(RandomNumberGenerator.createRandomNumber());
			ResultView.printMove(moveResult);
		}
	}
}
