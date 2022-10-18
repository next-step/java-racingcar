package step5.model;

import java.util.Objects;

public class Position {
	private int position;

	public Position(final int position) {
		this.position = position;
	}

	public void increase() {
		this.position++;
	}

	boolean isSamePosition(final int maxMoveCnt) {
		return maxMoveCnt == position;
	}

	int maxPosition(final int position) {
		return Math.max(this.position, position);
	}

	public int getPosition() {
		return this.position;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Position position1 = (Position) o;
		return position == position1.position;
	}

	@Override
	public int hashCode() {
		return Objects.hash(position);
	}
}
