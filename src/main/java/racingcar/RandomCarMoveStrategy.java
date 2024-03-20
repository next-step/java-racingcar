package racingcar;

import java.util.Random;

public class RandomCarMoveStrategy implements CarMoveStrategy {
	private static final int standardNumber = 4;

	@Override
	public boolean isMovable() {
		return new Random().nextInt(10) >= standardNumber;
	}
}
