package racingcar.domain;

import racingcar.utils.RandomNumberGenerator;

public class RacingCarGame {
	private final Cars cars;
	private final TryNumber tryNumber;

	public RacingCarGame(Names names, TryNumber tryNumber) {
		this.cars = new Cars(names);
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
