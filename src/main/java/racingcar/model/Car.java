package racingcar.model;

public final class Car {
	private final String name;

	public String name() {
		return name;
	}

	private Integer distance;

	public Integer distance() {
		return distance;
	}

	public Car(final String name) {
		this.name = name;
		this.distance = 0;
	}

	public Car(final String name, final Integer distance) {
		this.name = name;
		this.distance = distance;
	}

	public void move(final int randomNumber) {
		if (randomNumber >= 4) {
			distance++;
		}
	}
}
