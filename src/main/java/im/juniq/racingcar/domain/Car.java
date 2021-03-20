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

	public Car(String name, int position, MovingStrategy movingStrategy) {
		this(name, movingStrategy);
		this.position = new Position(position);
	}

	public void move() {
		if (movingStrategy.movable()) {
			position.increase();
		}
	}

	protected Name name() {
		return name;
	}

	protected Position position() {
		return position;
	}
}
