package racingcar;

public class Game {
	private int numberOfCar;
	private int numberOfTrial;
	private Car[] cars;

	private Game() {
		setGameConditions();
		setCars();

		PrintView.printResultMessage();

		for(int i = 0; i < numberOfTrial; i++) {
			tryGame(i);
		}
	}

	public static Game play() {
		return new Game();
	}

	private void setGameConditions() {
		numberOfCar = InputView.inputNumberOfCar();
		numberOfTrial = InputView.inputNumberOfTrial();
		cars = new Car[numberOfCar];
	}

	private void setCars() {
		for(int i = 0; i < numberOfCar; i++) {
			cars[i] = new Car(numberOfTrial);
		}
	}

	private void tryGame(int trial) {
		for(Car car : cars) {
			car.moveOrStop(trial);
			PrintView.printCarMoving(car.getMoving(), trial);
		}

		PrintView.printEmptyLine();
	}
}
