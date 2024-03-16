package racingcar;

public class Game {
	public Game() {
	}

	public void play(int numberOfCar, int numberOfTrial) {
		Car[] cars = setCars(numberOfCar);

		PrintView.printResultMessage();

		for(int i = 0; i < numberOfTrial; i++) {
			tryGame(cars);
		}
	}

	private Car[] setCars(int numberOfCar) {
		Car[] cars = new Car[numberOfCar];

		for(int i = 0; i < numberOfCar; i++) {
			cars[i] = new Car();
		}

		return cars;
	}

	private void tryGame(Car[] cars) {
		for(Car car : cars) {
			car.move();
			PrintView.printCarMoving(car);
		}

		PrintView.printEmptyLine();
	}
}
