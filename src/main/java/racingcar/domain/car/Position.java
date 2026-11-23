package racingcar.domain.car;

public class Position {

	private int position;

	private static final int START_POSITION = 0;

	public Position() {
		this(START_POSITION);
	}

	public Position(int position) {
		if (position < START_POSITION) {
			throw new IllegalArgumentException("위치는 0이상이어야한다.");
		}
		this.position = position;
	}

	public int getPosition() {
		return position;
	}

	public void go() {
		position++;
	}
}
