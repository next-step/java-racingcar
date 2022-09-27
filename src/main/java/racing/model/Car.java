package racing.model;

public class Car {

	private static final int MOVING_SIZE = 1;
	private static final int MOVABLE_NUMBER = 4;
	private Position position;

	public Car() {
		this.position = new Position(0);
	}

	public void move(int random) {
		if (isMovable(random)) {
			this.position = new Position(position.getPosition() + MOVING_SIZE);
		}
	}

	private boolean isMovable(int random) {
		return random >= MOVABLE_NUMBER;
	}

	public int getPosition() {
		return position.getPosition();
	}
}
