package carRacing.level3.model;

import carRacing.level3.model.strategy.MovingStrategy;

public class Car {

	private static final int DEFAULT_LOCATION = 0;
	private static final int MOVE_LOCATION = 1;
	private int location;

	public Car() {
		this.location = DEFAULT_LOCATION;
	}

	public int carLocation() {
		return location;
	}

	public void moveLocation(MovingStrategy strategy) {
		if (strategy.isMovable()) {
			location += MOVE_LOCATION;
		}
	}
}
