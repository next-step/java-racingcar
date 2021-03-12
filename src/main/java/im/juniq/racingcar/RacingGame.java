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
		createCars(InputView.getCarCount());
		racing(InputView.getTryCount());
	}

	public void createCars(int carCount) {
		for (int i = 0; i < carCount; i++) {
			cars.add(new Car(i));
		}
	}

	private void racing(int moveCount) {
		for (int i = 0; i < moveCount; i++) {
			moveCars();
			printCarsMoveCount();
		}
	}

	public void moveCars() {
		for (Car car : cars) {
			car.move();
		}
	}

	private void printCarsMoveCount() {
		ResultView.printCarMoveCount(cars);
	}

	public List<Car> getCars() {
		return cars;
	}
}
