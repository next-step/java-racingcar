package racing.model;

public class Car {

	private Position position;
	private final Name name;

	public Car(Name name) {
		this.position = Position.ZERO;
		this.name = name;
	}

	public void move(boolean isMovable) {
		if (isMovable) {
			position = position.move();
		}
	}

	public Position getPosition() {
		return position;
	}

	public Name getName() {
		return name;
	}
}
