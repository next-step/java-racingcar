package study.racingcar.domain;

public class Car {

	private final Position position;

	public Car() {
		this.position = new Position();
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
