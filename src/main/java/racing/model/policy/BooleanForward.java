package racing.model.policy;

import racing.model.policy.inter.ForwardPolicy;

import java.util.Random;

public class BooleanForward implements ForwardPolicy {

	private Random random = new Random();

	@Override
	public boolean forward() {
		return random.nextBoolean();
	}

}
