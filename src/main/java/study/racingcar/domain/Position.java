package study.racingcar.domain;

import java.util.Objects;

public class Position {

	public static final int INIT_POSITION = 0;
	private static final int ONE_STEP = 1;

	private final int position;

	public Position() {
		this.position = INIT_POSITION;
	}

	public Position(int position) {
		this.position = position;
	}

	public Position move() {
		return new Position(position + ONE_STEP);
	}

	public int value() {
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
