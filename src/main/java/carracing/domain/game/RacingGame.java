package carracing.domain.game;

import carracing.domain.car.Cars;

public class RacingGame {
	private final Cars cars;

	public RacingGame(Cars cars) {
		this.cars = cars;
	}

	public void race(MovingStrategy movingStrategy, int tryingNumber) {
		this.cars.race(movingStrategy, tryingNumber);
	}

	public void race(MovingStrategy movingStrategy) {
		this.cars.race(movingStrategy);
	}
}
