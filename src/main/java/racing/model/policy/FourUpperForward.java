package racing.model.policy;

import racing.model.policy.inter.ForwardPolicy;

import java.util.Random;

public class FourUpperForward implements ForwardPolicy {

	private static final int FORWARD_CRITERIA = 4;

	private static final int MAX_RANDOM_BOUND = 10;

	private Random random = new Random();

	@Override
	public boolean forward() {
		return random.nextInt(MAX_RANDOM_BOUND) >= FORWARD_CRITERIA;
	}

}
