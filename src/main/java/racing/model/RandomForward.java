package racing.model;

import racing.model.inter.ForwardPolicy;

import java.util.Random;

public class RandomForward implements ForwardPolicy {

	public static final int FORWARD_CRITERIA = 4;

	public static final int MAX_RANDOM_BOUND = 10;

	Random random = new Random();

	@Override
	public boolean forward() {
		return random.nextInt(MAX_RANDOM_BOUND) >= FORWARD_CRITERIA;
	}

}
