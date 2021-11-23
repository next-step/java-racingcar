package study.racingcar.domain;

import java.util.Objects;

public class Position {

	private static final int INIT_POSITION = 0;

	private int position;

	public Position() {
		this.position = INIT_POSITION;
	}

	public Position(int position) {
		this.position = position;
	}

	public void add() {
		this.position++;
	}

	public int valueOfPosition() {
		return position;
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
