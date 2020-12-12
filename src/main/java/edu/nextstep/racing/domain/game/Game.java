package edu.nextstep.racing.domain.game;

import java.util.List;

import edu.nextstep.racing.domain.game.cars.Cars;
import edu.nextstep.racing.domain.game.cars.car.Car;

public class Game {
	private final Cars cars;
	private final MoveCount moveCount;

	public Game(List<Car> cars, int maxMoveCount) {
		this.cars = new Cars(cars);
		this.moveCount = new MoveCount(maxMoveCount);
	}

	public void play() {
		if (moveCount.isContinue()) {
			cars.moveAll();
			moveCount.countUp();
		}
	}

	public boolean isContinue() {
		return moveCount.isContinue();
	}

	public Cars getHeadCars() {
		return cars.getHeadCars();
	}

	public Cars getCars() {
		return cars;
	}
}
