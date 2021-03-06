package camp.nextstep.edu.racingcar.module;

public class RandomMovingStrategy implements MovingStrategy {
	private final static int MOVE_CONDITION = 4;
	private final RandomGenerator randomGenerator;

	private RandomMovingStrategy() {
		this.randomGenerator = RandomGenerator.getInstance();
	}

	private static class LazyHolder {
		static final RandomMovingStrategy INSTANCE = new RandomMovingStrategy();
	}

	public static RandomMovingStrategy getInstance() {
		return RandomMovingStrategy.LazyHolder.INSTANCE;
	}

	@Override
	public boolean moveable() {
		return randomGenerator.generateRandomNumber() >= MOVE_CONDITION;
	}
}
