package racingcar.model;

public class Car {
	private final Position position;

	private Car() {
		this(Position.create());
	}

	private Car(Position position) {
		this.position = position;
	}

	public static Car create() {
		return new Car();
	}
}
