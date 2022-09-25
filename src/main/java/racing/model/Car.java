package racing.model;

public class Car {

	private int position;

	public Car() {
		this.position = 0;
	}

	public void move(int random) {
		if (isMovable(random)) {
			position += 1;
		}
	}

	private boolean isMovable(int random) {
		return random >= 4;
	}

	public int getPosition() {
		return position;
	}
}
