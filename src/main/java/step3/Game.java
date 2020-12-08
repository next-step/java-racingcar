package step3;

import java.util.List;

public class Game {
	private List<Car> gameCars;
	private int moveTryMaxCount;
	private int moveTryCurrentCount;

	public Game(List<Car> gameCars, int moveTryMaxCount) {
		this.gameCars = gameCars;
		this.moveTryMaxCount = moveTryMaxCount;
	}

	public List<Car> getGameCars() {
		return gameCars;
	}

	public int getMoveTryMaxCount() {
		return moveTryMaxCount;
	}

	public void tryToMoveAllGameCars() {
		for (Car gameCar : gameCars) {
			gameCar.tryToMove();
		}
	}

	public boolean isContinue() {
		return moveTryCurrentCount < moveTryMaxCount;
	}

	public void play() {
		tryToMoveAllGameCars();
		moveTryCurrentCount++;
	}
}
