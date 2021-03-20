package im.juniq.racingcar.domain;

import java.util.Random;

public class RandomNumberMovingStrategy implements MovingStrategy {
	private static final int BOUND_OF_CAR_MOVEMENT = 4;

	private RandomNumber randomNumber = new RandomNumberZeroToNine(new Random());

	@Override
	public boolean isMoving() {
		return randomNumber.value() > BOUND_OF_CAR_MOVEMENT;
	}

	public void setRandomNumber(RandomNumber randomNumber) {
		this.randomNumber = randomNumber;
	}
}
