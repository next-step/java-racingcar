package racingcar;

import java.util.Objects;

public class Position {

	private final int position;

	public Position() {
		this(0);
	}

	public Position(int position) {
		this.position = position;
	}

	public Position increase() {
		return new Position(this.position + 1);
	}

	public boolean hasSamePosition(int max) {
		return this.position == max;
	}

	public int getPosition() {
		return this.position;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Position position1 = (Position)o;
		return position == position1.position;
	}

	@Override
	public int hashCode() {
		return Objects.hash(position);
	}
}
