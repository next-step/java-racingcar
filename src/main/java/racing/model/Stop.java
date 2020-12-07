package racing.model;

import racing.model.inter.ForwardPolicy;
import racing.util.Constants;

public class Stop implements ForwardPolicy {

	@Override
	public boolean forward() {
		return false;
	}

}
