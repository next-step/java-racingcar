package step4.model;

public class Position {
	private int position;

	public Position(final int position) {
		this.position = position;
	}

	public Position increase(final Position position) {
		position.position++;
		return position;
	}

	boolean isMaxPosition(final int maxMoveCnt) {
		return maxMoveCnt == position;
	}

	int maxPosition(final int position) {
		return Math.max(this.position, position);
	}

	public int getPosition() {
		return this.position;
	}
}
