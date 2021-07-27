package racing.domain;

import racing.utils.Validation;

public class Position {

	private static final String POSITIVE_CHECK_MESSAGE = "음수값을 가질수 없습니다.";
	private int position;

	public Position(int position) {
		Validation.validPositiveCheck(position, POSITIVE_CHECK_MESSAGE);
		this.position = position;
	}

	public Position move() {
		position += 1;
		return this;
	}

	public int resultPosition() {
		return position;
	}

	public boolean maxPositionCheck(int maxPosition) {
		return position == maxPosition;
	}
}
