package racing.model;

public class Car {

	private static final int MOVING_SIZE = 1;
	private final Position position;
	private final Name name;

	public Car(Name name) {
		this.position = new Position(0);
		this.name = name;
	}

	public Position move(boolean isMovable) {
		if (isMovable) {
			position.move();
		}
		return position;
	}

	public int getPosition() {
		return position.getPosition();
	}

	public String getName() {
		return name.getName();
	}
}
