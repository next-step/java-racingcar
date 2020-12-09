package edu.nextstep.racing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

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

	public List<Car> getHeadCars() {
		if (gameCars == null || gameCars.isEmpty()) {
			return Collections.emptyList();
		}

		PriorityQueue<Car> carRanking = new PriorityQueue<>((car1, car2) -> car2.getLocation() - car1.getLocation());
		carRanking.addAll(gameCars);

		List<Car> headCars = new ArrayList<>();
		int maxLocation = carRanking.peek().getLocation();
		while (!carRanking.isEmpty() && carRanking.peek().getLocation() == maxLocation) {
			headCars.add(carRanking.poll());
		}

		return headCars;
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
