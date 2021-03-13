package im.juniq.racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
	private List<Car> cars = new ArrayList<>();

	public static void main(String[] args) {
		RacingGame racingGame = new RacingGame();
		racingGame.play();
	}

	public void play() {
		InputView.scan();
		createCars(InputView.getNumberOfCars());
		racing(InputView.getNumberOfTries());
	}

	public void createCars(int carCount) {
		for (int i = 0; i < carCount; i++) {
			cars.add(new Car(i));
		}
	}

	private void racing(int moveCount) {
		for (int i = 0; i < moveCount; i++) {
			moveCars(new RandomNumberZeroToNine());
			printCarsMoveCount();
		}
	}

	public void moveCars(RandomNumber randomNumber) {
		for (Car car : cars) {
			car.move(randomNumber);
		}
	}

	private void printCarsMoveCount() {
		ResultView.printCarMoveCount(cars);
	}

	public List<Car> getCars() {
		return cars;
	}
}
