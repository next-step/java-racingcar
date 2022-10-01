package racing.model;

import java.util.Objects;

public class Position {

	private int position;

	public Position(int position) {
		if (!isValid(position)) {
			throw new IllegalArgumentException("잘못된 위치 입니다.");
		}
		this.position = position;
	}

	private boolean isValid(int position) {
		return position >= 0;
	}

	public void move() {
		position++;
	}

	public int getPosition() {
		return position;
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
