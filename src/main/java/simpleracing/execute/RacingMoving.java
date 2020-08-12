package simpleracing.execute;

import java.util.Random;

public class RacingMoving implements Movable {
	private static final int RANDOM_MAX_VALUE = 10;
	private Random randomValueGenerator;

	public RacingMoving() {
		this.randomValueGenerator = new Random();
	}

	@Override
	public boolean possible() {
		int value = randomValueGenerator.nextInt(RANDOM_MAX_VALUE);
		return Direction.getBy(value) == Direction.ADVANCE;
	}
}
