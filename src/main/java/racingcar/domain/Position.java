package racingcar.domain;

public class Position implements Comparable<Position> {

	private static final int INCREASE_AMOUNT = 1;
	private final int position;

	public Position() {
		this(0);
	}

	public Position(int position) {
		this.position = position;
	}

	public Position increase() {
		return new Position(position + INCREASE_AMOUNT);
	}

	public int getPosition() {
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
		return position;
	}

	@Override
	public int compareTo(Position o) {
		return Integer.compare(position, o.position);
	}
}
