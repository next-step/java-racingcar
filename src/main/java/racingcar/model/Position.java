package racingcar.model;

public class Position {
	private static final int DEFAULT_POSITION = 1;

	private Integer position;

	private Position() {
		position = DEFAULT_POSITION;
	}

	public static Position create() {
		return new Position();
	}

	public void increase() {
		position++;
	}

	public String convertPositionToDash() {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < position; i++) {
			builder.append("-");
		}
		return builder.toString();
	}
}
