package step4.domain;

import java.util.Random;

public class DefaultRandomMoveStrategy implements CarMoveStrategy {
	public static final int MIN_MOVE_VALUE = 4;
	private static final int RANDOM_BOUND = 10;
	private final Random random;

	public DefaultRandomMoveStrategy(Random random) {
		this.random = random;
	}

	@Override
	public int speed() {
		return Car.DEFAULT_SPEED;
	}

	@Override
	public boolean movable() {
		return random.nextInt(RANDOM_BOUND) >= MIN_MOVE_VALUE;
	}
}
