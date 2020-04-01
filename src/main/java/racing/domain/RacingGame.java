package racing.domain;

import racing.vo.Cars;
import racing.vo.MoveCount;

public class RacingGame {

	private final MoveCount times;
	private final Cars cars;

	public RacingGame(Cars cars, MoveCount times) {
		this.cars = cars;
		this.times = times;
	}

	public boolean isEnd(final int currentCycle) {
		return times.isNotInCycle(currentCycle);
	}
	
	public Cars move() {
		return cars.move();
	}

	public Cars getWinner() {
		return cars.getWinner();
	}
}
