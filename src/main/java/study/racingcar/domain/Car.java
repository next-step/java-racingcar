package study.racingcar.domain;

public class Car {

	private final Position position;
	private final Name name;

	public Car(String name) {
		this.position = new Position();
		this.name = new Name(name);
	}

	public Position carPosition() {
		return this.position;
	}

	public void go(boolean isMoveCar) {
		if (isMoveCar) {
			this.position.add();
		}
	}

}
