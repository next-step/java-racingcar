package carRacing.level3.domain;

public class Car {

	private static final Integer DEFAULT_LOCATION = 1;
	private static final Integer MOVE_LOCATION = 1;
	private Integer location;

	public Car() {
		this.location = DEFAULT_LOCATION;
	}

	public int carLocation() {
		return location;
	}

	public void moveLocation() {
		this.location += MOVE_LOCATION;
	}
}
