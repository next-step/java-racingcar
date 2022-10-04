package racingcar;

public class Car {
	private static final int MOVING_CONDITION = 4;
	private Name name;
	private Position position;

	public Car(String name) {
		this.name = new Name(name);
		this.position = new Position();
	}

	public void movingOfRound(int random) {
		if (random >= MOVING_CONDITION) {
			this.position = this.position.increase();
		}
	}

	public Position getStatus() {
		return this.position;
	}

	public Name getName() {
		return name;
	}
}
