package im.juniq.racingcar.domain;

public class Car {
	private Name name;
	private Position position;
	private MovingStrategy movingStrategy;

	public Car(String name, MovingStrategy movingStrategy) {
		this.name = new Name(name);
		this.position = new Position();
		this.movingStrategy = movingStrategy;
	}

	public void move() {
		if (movingStrategy.movable()) {
			position.increase();
		}
	}

	public Name name() {
		return name;
	}

	public Position position() {
		return position;
	}
}
