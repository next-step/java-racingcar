package step3;

import java.util.ArrayList;
import java.util.List;

public class Playground {

	public Game createRacingGame(int numberOfCars, int moveTryMaxCount) {
		List<Car> gameCars = createGameCars(numberOfCars);
		return new Game(gameCars, moveTryMaxCount);
	}

	public List<Car> createGameCars(int numberOfCars) {
		List<Car> entry = new ArrayList<>();
		for (int i = 0; i < numberOfCars; i++) {
			entry.add(new Car());
		}
		return entry;
	}

	public void play() {
		int numberOfCars = InputView.inputNumberOfCars();
		int moveTryMaxCount = InputView.inputMoveTryMaxCount();
	}
}
