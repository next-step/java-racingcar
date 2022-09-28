package racing.model;

public class Car {

	private static final int MOVING_SIZE = 1;
	private Position position;

	public Car() {
		this.position = new Position(0);
	}

	public void move(boolean isMovable) {
		if (isMovable) {
			this.position = new Position(position.getPosition() + MOVING_SIZE);
		}
	}

	public int getPosition() {
		return position.getPosition();
	}
}
