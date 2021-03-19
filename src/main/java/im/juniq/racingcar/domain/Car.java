package im.juniq.racingcar.domain;

public class Car {
	private static final int CAR_NAME_LENGTH_LIMIT = 5;
	private Name name;
	private Position position;
	private MovingStrategy movingStrategy;

	public Car(String name, MovingStrategy movingStrategy) {
		checkCarName(name);
		this.name = new Name(name);
		this.position = new Position();
		this.movingStrategy = movingStrategy;
	}

	private void checkCarName(String name) {
		if (name.length() > CAR_NAME_LENGTH_LIMIT) {
			throw new IllegalArgumentException("자동차 이름은 5자 이하이어야 합니다.");
		}
	}

	public void move() {
		if (movingStrategy.isMoving()) {
			position.increase();
		}
	}

	public void move(MovingStrategy movingStrategy) {
		if (movingStrategy.isMoving()) {
			position.increase();
		}
	}

	public Name name() {
		return name;
	}

	public Position position() {
		return position;
	}

	public String getStatus() {
		String status = name + " : ";
		for (int i = 0; i < position.position(); i++) {
			status += "-";
		}
		return status;
	}
}
