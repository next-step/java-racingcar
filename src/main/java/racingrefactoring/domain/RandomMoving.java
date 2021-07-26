package racingrefactoring.domain;

public class RandomMoving implements Moving {

	private static final int FORWARD_STANDARD = 4;

	@Override
	public boolean canMoveForward() {
		return RandomGenerator.generate() >= FORWARD_STANDARD;
	}

}
