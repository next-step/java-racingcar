package racingGame;

import racingGame.domain.Engine;

import java.util.Random;

class RandomEngine implements Engine {
	private static final int RANDOM_RANGE = 10;
	private static final int GO_THRESHOLD = 4;

	private Random random = new Random();

	@Override
	public int moveDistanceForOneTime() {
		if (canGo()) {
			return 1;
		}

		return 0;
	}

	private boolean canGo() {
		return random.nextInt(RANDOM_RANGE) > GO_THRESHOLD;
	}
}