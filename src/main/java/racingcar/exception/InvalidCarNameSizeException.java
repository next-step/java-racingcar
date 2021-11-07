package racingcar.exception;

import racingcar.model.Car;

public class InvalidCarNameSizeException extends IllegalArgumentException {
	private static final long serialVersionUID = -4791840632122469939L;

	public InvalidCarNameSizeException() {
		super("car name must be less than or equal to " + Car.MAX_OF_CAR_NAME);
	}
}
