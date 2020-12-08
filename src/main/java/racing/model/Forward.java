package racing.model;

import racing.model.inter.ForwardPolicy;

public class Forward implements ForwardPolicy {

	@Override
	public boolean forward() {
		return true;
	}
}
