package carRacing.moveStrategy;

import java.util.Random;

public class RandomMoveStrategy implements MoveStrategy {

	private static final int MAXIMUM_BOUND = 10;
	private static final int MINIMUM_TO_MOVE = 4;

	private Random random = new Random();

	@Override
	public boolean isForward() {
		if(random.nextInt(MAXIMUM_BOUND) >= MINIMUM_TO_MOVE ) {
			return true;
		}
		return false;
	}
}
