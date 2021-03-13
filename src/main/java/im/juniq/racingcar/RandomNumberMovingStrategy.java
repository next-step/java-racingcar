package im.juniq.racingcar;

public class RandomNumberMovingStrategy implements MovingStrategy {
	private static final int BOUND_OF_CAR_MOVEMENT = 4;

	private RandomNumber randomNumber = new RandomNumberZeroToNine();

	@Override
	public boolean isMoving() {
		return randomNumber.get() > BOUND_OF_CAR_MOVEMENT;
	}

	public void setRandomNumber(RandomNumber randomNumber) {
		this.randomNumber = randomNumber;
	}
}
