package racingcar.model;

public final class Car {
	private final Name name;

	private Distance distance;

	public Car(final String name) {
		this(name, new Distance(0));
	}

	public Car(final String name, final Distance distance) {
		this.name = new Name(name);
		this.distance = distance;
	}

	public Name name() {
		return name;
	}

	public Distance distance() {
		return distance;
	}

	public void move(final int randomNumber) {
		if (randomNumber >= 4) {
			this.distance.move();
		}
	}
}
