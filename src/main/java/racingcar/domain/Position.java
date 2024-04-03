package racingcar.domain;

import java.util.Objects;

public class Position {
	private int value;

	public Position() {
		this(0);
	}

	public Position(int value) {
		assertionPositiveNumber(value);
		this.value = value;
	}

	private void assertionPositiveNumber(int value) {
		if (value < 0) {
			throw new IllegalArgumentException("위치는 음수를 가질 수 없습니다.");
		}
	}

	public int getValue() {
		return this.value;
	}

	public void moveForward() {
		this.value++;
	}

	public boolean longestThen(Position position) {
		return this.value >= position.getValue();
	}

	public Position max(int that) {
		return new Position(Math.max(this.value, that));
	}

	public Position max(Position that) {
		return max(that.value);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Position position1 = (Position)o;
		return value == position1.value;
	}

	@Override
	public int hashCode() {
		return Objects.hash(value);
	}
}

