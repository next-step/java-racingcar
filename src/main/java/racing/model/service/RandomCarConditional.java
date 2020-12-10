package racing.model.service;

import java.util.Random;

public class RandomCarConditional implements CarConditional {

	private static final int RACING_RANDOM_BOUND = 10;
	private static final int RACING_INCREASE_BOUND = 3;
	private static final Random randomGenerator = new Random();

	@Override
	public boolean isMove() {

		return randomGenerator.nextInt(RACING_RANDOM_BOUND) > RACING_INCREASE_BOUND; // 0 <= RandomNumber < 10
	}
}
