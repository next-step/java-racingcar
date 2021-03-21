package im.juniq.racingcar.domain;

import java.util.Random;

public class RandomNumberMovingStrategy implements MovingStrategy {
	private static final int BOUND_OF_CAR_MOVEMENT = 4;
	private RandomNumber randomNumber;

	public RandomNumberMovingStrategy() {
		randomNumber = new RandomNumberZeroToNine(new Random());
	}

	public RandomNumberMovingStrategy(RandomNumber randomNumber) {
		this.randomNumber = randomNumber;
	}

	@Override
	public boolean movable() {
		return randomNumber.value() > BOUND_OF_CAR_MOVEMENT;
	}
}
