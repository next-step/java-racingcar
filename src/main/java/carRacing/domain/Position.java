package carRacing.domain;

public class Position {

	private static final int DEFAULT_POSITION = 0;

	private int position;

	public Position(int position) {
		this.position = isPositionPositive(position);
	}

	private int isPositionPositive(int position) {
		if(position < DEFAULT_POSITION) {
			throw new IllegalArgumentException("위치는 음수일 수 없습니다.");
		}
		return position;
	}

	public void increasePosition() {
		this.position++;
	}
}
