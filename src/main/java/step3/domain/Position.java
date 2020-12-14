package step3.domain;

import java.util.Objects;

import step3.utils.ValidationUtils;

public class Position {
	private int position;

	public Position(int position) {
		ValidationUtils.validatePositive(position);
		this.position = position;
	}

	public void go() {
		position++;
	}

	public int getPosition() {
		return this.position;
	}

	public boolean isMaxPosition(int maxPosition) {
		return position == maxPosition;
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
