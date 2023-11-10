package carracing.car;

public class RacingGame {
	private final Cars cars;

	public RacingGame(Cars cars) {
		this.cars = cars;
	}

	public void race(MovingStrategy movingStrategy, int tryingTimes) {
		cars.race(movingStrategy, tryingTimes);
	}
}
