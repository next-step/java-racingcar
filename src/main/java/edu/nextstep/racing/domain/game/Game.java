package edu.nextstep.racing.domain.game;

import edu.nextstep.racing.domain.game.cars.Cars;

public class Game {
	private final Cars cars;
	private final MoveCount moveCount;

	public Game(Cars cars, int maxMoveCount) {
		this.cars = cars;
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
