package racing.model;

import racing.model.inter.ForwardPolicy;
import racing.util.Constants;

import java.util.Random;

public class RandomForward implements ForwardPolicy {

	Random random = new Random();

	@Override
	public boolean forward() {
		return random.nextInt(Constants.MAX_RANDOM_BOUND) >= Constants.FORWARD_CRITERIA;
	}

}
