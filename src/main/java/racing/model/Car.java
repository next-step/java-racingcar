package racing.model;

public class Car {

	private static final int MOVING_SIZE = 1;
	private static final int MOVABLE_NUMBER = 4;
	private int position;

	public Car() {
		this.position = 0;
	}

	public void move(int random) {
		if (isMovable(random)) {
			position += MOVING_SIZE;
		}
	}

	private boolean isMovable(int random) {
		return random >= MOVABLE_NUMBER;
	}

	public int getPosition() {
		return position;
	}
}
