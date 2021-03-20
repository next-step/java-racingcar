package im.juniq.racingcar.domain;

import java.util.Objects;

public class Position implements Comparable<Position> {
	private int position;

	public Position() {
		this.position = 0;
	}

	public Position(int position) {
		this.position = position;
	}

	public void increase() {
		position++;
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

	@Override
	public int compareTo(Position o) {
		return Integer.compare(position, o.position);
	}

	public int value() {
		return position;
	}
}
