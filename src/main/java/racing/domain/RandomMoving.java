package racing.domain;

public class RandomMoving implements Moving {

	private static final int RANDOM_RANGE = 10;
	private static final int RANDOM_CHECK_NUMBER = 3;
	RandomGenerator randomGenerator = new RandomGenerator();

	@Override
	public boolean movable() {
		return randomGenerator.randomGenerate(RANDOM_RANGE) > RANDOM_CHECK_NUMBER;
	}

}
