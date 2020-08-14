package simpleracing.domain.rule;

import java.util.Random;

public class CarRacingMoving implements Moving {
	private static final int RANDOM_MAX_VALUE = 10;
	private static final int ADVANCE_CONDITION_VALUE = 4;

	private Random randomValueGenerator;

	public CarRacingMoving() {
		this.randomValueGenerator = new Random();
	}

	@Override
	public boolean isPossible() {
		return randomValueGenerator.nextInt(RANDOM_MAX_VALUE) >= ADVANCE_CONDITION_VALUE;
	}
}
