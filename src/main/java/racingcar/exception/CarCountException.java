package racingcar.exception;

public class CarCountException extends RuntimeException {

	public static final String MESSAGE_EMPTY_CARS = "자동차는 1개 이상이어야 합니다";

	public CarCountException() {
		this(MESSAGE_EMPTY_CARS);
	}

	public CarCountException(String message) {
		super(message);
	}
}
