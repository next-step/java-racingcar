package domain;

import java.util.Objects;

public class Position {
	private int position;

	private Position() {
	}

	public Position(int position) {
		this.position = position;
	}

	public void increment() {
		position++;
	}

	public Integer getPosition() {
		return position;
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		final Position position1 = (Position) o;
		return position == position1.position;
	}

	@Override
	public int hashCode() {
		return Objects.hash(position);
	}
}
