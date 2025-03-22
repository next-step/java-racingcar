package racingcar.domain;

public class RandomMovingStrategy implements MovingStrategy {
	private static final int MIN_MOVE_VALUE = 4;

	@Override
	public boolean canGo() {
		int randomNumber = RandomNumberGenerator.generateRandomNumber();
		return randomNumber >= MIN_MOVE_VALUE;
	}
}
