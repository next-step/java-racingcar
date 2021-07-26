package racingrefactoring.domain;

public class CarNameException extends RuntimeException {

	private static final String DEFAULT_MESSAGE = "자동차 이름은 5자를 초과할 수 없습니다.";

	public CarNameException() {
		super(DEFAULT_MESSAGE);
	}

}
