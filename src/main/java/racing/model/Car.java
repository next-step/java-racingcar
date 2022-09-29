package racing.model;

public class Car {

	private static final int MOVING_SIZE = 1;
	private final Position position;

	public Car() {
		this.position = new Position(0);
	}

	public void move(boolean isMovable) {
		if (isMovable) {
			position.move();
		}
	}

	public int getPosition() {
		return position.getPosition();
	}
}
