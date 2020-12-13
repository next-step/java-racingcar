package step3.domain;

import step3.utils.RandomNumberGenerator;

public class RacingCarGame {
	private final Cars cars;
	private final TryNumber tryNumber;

	public RacingCarGame(CarNumber carNumber, TryNumber tryNumber) {
		this.cars = new Cars(carNumber);
		this.tryNumber = tryNumber;
	}

	public void play() {
		tryNumber.play();
		cars.goOrStop(RandomNumberGenerator.getInstance());
	}

	public Cars getCars() {
		return this.cars;
	}

	public boolean playing() {
		return tryNumber.playing();
	}
}
