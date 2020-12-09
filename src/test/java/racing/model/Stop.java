package racing.model;

import racing.model.inter.ForwardPolicy;

public class Stop implements ForwardPolicy {

	@Override
	public boolean forward() {
		return false;
	}

}
