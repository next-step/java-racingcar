package racing.model;

public class Car {

	private Position position;
	private final Name name;

	public Car(Name name) {
		this.position = new Position(0);
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
