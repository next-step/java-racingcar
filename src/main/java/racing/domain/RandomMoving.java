package racing.domain;

public class RandomMoving implements Moving {

	private static final int RANDOM_CHECK_NUMBER = 3;

	@Override
	public boolean movable(int randomValue) {
		return randomValue > RANDOM_CHECK_NUMBER;
	}

}
