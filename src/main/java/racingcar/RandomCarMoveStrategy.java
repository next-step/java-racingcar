package racingcar;

import java.util.Random;

public class RandomCarMoveStrategy implements CarMoveStrategy {
	private static final int standardNumber = 4;
	private static final Random random = new Random();

	@Override
	public boolean isMovable() {
		return random.nextInt(10) >= standardNumber;
	}
}
