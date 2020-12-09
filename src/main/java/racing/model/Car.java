package racing.model;

import racing.model.inter.ForwardPolicy;

public class Car {

	public static final int MAX_NAME_CHARACTER_LENGTH = 5;

	private String name;

	private int forwardPosition;

	public Car(String name) {
		if (isNotValidateName(name)) {
			throw new IllegalArgumentException();
		}
		this.name = name;
	}

	private boolean isNotValidateName(String name) {
		if (name == null || name.trim().isEmpty() || name.length() > MAX_NAME_CHARACTER_LENGTH) {
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
