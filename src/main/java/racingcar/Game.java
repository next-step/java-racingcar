package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Game {
	public void play(int numberOfCar, int numberOfTrial) {
		List<Car> cars = setCars(numberOfCar);

		PrintView.printResultMessage();

		for(int i = 0; i < numberOfTrial; i++) {
			tryGame(cars);
		}
	}

	private List<Car> setCars(int numberOfCar) {
		List<Car> cars = new ArrayList<>();

		for(int i = 0; i < numberOfCar; i++) {
			cars.add(new Car(new RandomCarMoveStrategy()));
		}

		return cars;
	}

	private void tryGame(List<Car> cars) {
		for(Car car : cars) {
			car.move();
			PrintView.printCarMoving(car);
		}

		PrintView.printEmptyLine();
	}
}
