package edu.nextstep.racing;

import java.util.ArrayList;
import java.util.List;

import edu.nextstep.racing.domain.game.cars.Cars;
import edu.nextstep.racing.domain.game.cars.car.Car;
import edu.nextstep.racing.domain.game.Game;
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
			ResultView.printCarsLocation(racingGame.getCars());
		}
		ResultView.printWinners(racingGame.getHeadCars());
	}

	public Game createRacingGame(String[] nameOfCars, int moveTryMaxCount) {
		Cars gameCars = createGameCars(nameOfCars);
		return new Game(gameCars, moveTryMaxCount);
	}

	public Cars createGameCars(String[] nameOfCars) {
		List<Car> gameCars = new ArrayList<>();
		for (String name : nameOfCars) {
			gameCars.add(new Car(name));
		}
		return new Cars(gameCars);
	}
}