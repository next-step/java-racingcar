package racingcar.model;

import java.util.Objects;

public class Position {
	public static final int DEFAULT_POSITION = 0;

	private Integer position;

	Position() {
		this(DEFAULT_POSITION);
	}

	Position(Integer position) {
		this.position = position;
	}

	public static Position create() {
		return new Position();
	}

	public void increase() {
		position++;
	}

	public String convertPositionToDash() {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i <= position; i++) {
			builder.append("-");
		}
		return builder.toString();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		Position position1 = (Position)o;

		return Objects.equals(position, position1.position);
	}

	@Override
	public int hashCode() {
		return position != null ? position.hashCode() : 0;
	}

}
