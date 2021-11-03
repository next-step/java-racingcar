package racingcar.model;

public class Position {
	private final Integer position;

	private Position() {
		this.position = 0;
	}

	public static Position create() {
		return new Position();
	}
}
