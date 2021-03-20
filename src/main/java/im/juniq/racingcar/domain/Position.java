package im.juniq.racingcar.domain;

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
	public int compareTo(Position o) {
		return Integer.compare(position, o.position);
	}

	public int value() {
		return position;
	}
}
