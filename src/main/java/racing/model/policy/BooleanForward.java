package racing.model.policy;

import racing.model.policy.inter.ForwardPolicy;

import java.util.Random;

public class NegativeNumberForward implements ForwardPolicy {

	private static final int FORWARD_CRITERIA = 0;

	private static final int MAX_RANDOM_BOUND = 10;

	private Random random = new Random();

	@Override
	public boolean forward() {
		return random.nextInt(-100) >= FORWARD_CRITERIA;
	}

}
