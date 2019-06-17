package racing.player;

import racing.car.RacingCar;
import racing.car.ThresholdEngineCar;

import java.util.Random;

public class RandomAcceleratePlayer extends Player {

	private static final int DEFAULT_RANDOM_BOUND = 10;

	Random randomAccelerator;

	int randomBound;

	public RandomAcceleratePlayer(RacingCar car) {
		this(car, DEFAULT_RANDOM_BOUND);
	}

	public RandomAcceleratePlayer(RacingCar car, int accelerateLimit) {
		super(car);

		this.randomAccelerator = new Random();
		this.randomBound = accelerateLimit;
	}

	@Override
	public void drive() {
		this.getCar().move(randomAccelerator.nextInt(randomBound));
	}
}
