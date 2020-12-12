package edu.nextstep.racing.domain;

import java.util.List;

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
