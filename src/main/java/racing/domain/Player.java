package racing.domain;

import java.util.Random;

public class Player {

	private static final int DEFAULT_RANDOM_BOUND = 10;

	private Random randomAccelerator;

	private RacingCar car;

	public Player(RacingCar car) {
		this.car = car;
		this.randomAccelerator = new Random();
	}

	public int drive() {
		this.car.move(randomAccelerator.nextInt(DEFAULT_RANDOM_BOUND));
		return car.getMileage();
	}
}
