package racingcar;

import java.util.Random;

public class RandomCarMoveStrategy implements CarMoveStrategy {
	@Override
	public boolean isMovable() {
		return new Random().nextInt(10) >= 4;
	}
}
