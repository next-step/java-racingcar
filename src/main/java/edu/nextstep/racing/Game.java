package edu.nextstep.racing;

import java.util.List;

public class Game {
	private List<Car> gameCars;
	private int moveTryMaxCount;
	private int moveTryCurrentCount;

	public Game(List<Car> gameCars, int moveTryMaxCount) {
		this.gameCars = gameCars;
		this.moveTryMaxCount = moveTryMaxCount;
	}

	public void play() {
		tryToMoveAllGameCars();
		moveTryCurrentCount++;
	}

	public void tryToMoveAllGameCars() {
		for (Car gameCar : gameCars) {
			gameCar.tryToMove();
		}
	}

	public boolean isContinue() {
		return moveTryCurrentCount < moveTryMaxCount;
	}

	public List<Car> getGameCars() {
		return gameCars;
	}

	public int getMoveTryMaxCount() {
		return moveTryMaxCount;
	}
}
