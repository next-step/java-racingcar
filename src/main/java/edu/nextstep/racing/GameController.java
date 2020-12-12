package edu.nextstep.racing;

import java.util.ArrayList;
import java.util.List;

import edu.nextstep.racing.domain.Car;
import edu.nextstep.racing.domain.Game;
import edu.nextstep.racing.view.InputView;
import edu.nextstep.racing.view.ResultView;

public class GameController {

	public void play() {
		String[] nameOfCars = InputView.inputNameOfCars();
		int moveTryMaxCount = InputView.inputMoveTryMaxCount();
		Game racingGame = createRacingGame(nameOfCars, moveTryMaxCount);
		ResultView.printGameStart();
		while (racingGame.isContinue()) {
			racingGame.play();
			ResultView.printCarsLocation(racingGame.getGameCars());
		}
		ResultView.printWinners(racingGame.getHeadCars());
	}

	public Game createRacingGame(String[] nameOfCars, int moveTryMaxCount) {
		List<Car> gameCars = createGameCars(nameOfCars);
		return new Game(gameCars, moveTryMaxCount);
	}

	public List<Car> createGameCars(String[] nameOfCars) {
		List<Car> entry = new ArrayList<>();
		for (String name : nameOfCars) {
			Car car = new Car();
			car.setName(name);
			entry.add(car);
		}
		return entry;
	}
}