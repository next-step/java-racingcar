package racing.model.car;

public class Position {
	private int position;

	public Position(int position) {
		this.position = position;
	}

	public Position deepCopy() {
		return new Position(position);
	}

	public boolean match(int position) {
		return this.position == position;
	}

	public void move() {
		this.position++;
	}

	public int current() {
		return this.position;
	}

}
