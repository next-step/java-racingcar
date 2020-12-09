package edu.nextstep.racing;

import java.util.ArrayList;
import java.util.List;

public class Playground {

	public void play() {
		int numberOfCars = InputView.inputNumberOfCars();
		int moveTryMaxCount = InputView.inputMoveTryMaxCount();
		Game racingGame = createRacingGame(numberOfCars, moveTryMaxCount);
		ResultView.printGameStart();
		while (racingGame.isContinue()) {
			racingGame.play();
			ResultView.printCarsLocation(racingGame.getGameCars());
		}
	}

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
}