package domain;

public class Position {
	private int position;

	private Position() {
	}

	public Position(int position) {
		this.position = position;
	}

	public void increment() {
		position++;
	}

	public Integer getPosition() {
		return position;
	}
}
