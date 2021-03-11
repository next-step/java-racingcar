package im.juniq.racingcar;

import java.util.ArrayList;
import java.util.List;

public class Game {
	private List<RacingCar> cars = new ArrayList<>();

	public void createCars(int carCount) {
		for (int i = 0; i < carCount; i++) {
			cars.add(new RacingCar(i));
		}
	}

	public void moveCars() {
		for (RacingCar racingCar: cars) {
			racingCar.move();
		}
	}

	public List<RacingCar> getCars() {
		return cars;
	}

	public void printCarsMoveCount() {
		ResultView.printCarMoveCount(cars);
	}
}
