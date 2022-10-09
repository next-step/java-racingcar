package racing.domain;

import racing.exception.ErrorMessage;
import racing.exception.InvalidCarNameLengthException;

public class CarName {
	private static final int CAR_NAME_MAX_LENGTH = 5;

	private String name;

	public CarName(String name) {
		if (!isValidCarNameLength(name)) {
			throw new InvalidCarNameLengthException(ErrorMessage.INVALID_CAR_NAME_LENGTH, name);
		}
		this.name = name;
	}

	private boolean isValidCarNameLength(String name) {
		return name.length() <= CAR_NAME_MAX_LENGTH;
	}

	public String getName() {
		return name;
	}
}
