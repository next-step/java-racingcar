package racing.model;

import racing.model.inter.ForwardPolicy;
import racing.util.Constants;

public class Car {

	private String name;

	private int forwardPosition;

	public Car(String name) {
		if (isNotValidateName(name)) {
			throw new IllegalArgumentException();
		}
		this.name = name;
	}

	private boolean isNotValidateName(String name) {
		if (name == null || name.trim().isEmpty() || name.length() > Constants.MAX_NAME_CHARACTER_LENGTH) {
			return true;
		}
		return false;
	}

	public String getName() {
		return name;
	}

	public int getForwardPosition() {
		return forwardPosition;
	}

	public void speedUp(ForwardPolicy forwardPolicy) {
		if (forwardPolicy.forward()) {
			this.forwardPosition += 1;
		}
	}

}
