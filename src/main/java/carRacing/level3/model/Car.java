package carRacing.level3.model;

import carRacing.level3.model.strategy.MovingStrategy;

public class Car {

	private static final int DEFAULT_LOCATION = 0;
	private static final int MOVE_LOCATION = 1;
	private int location;
	private String carName;

	public Car(String carName) {
		this.location = DEFAULT_LOCATION;
		this.carName = carName;
	}

	public int carLocation() {
		return location;
	}

	public String carName() {
		return carName;
	}

	public void moveLocation(MovingStrategy strategy) {
		if (strategy.isMovable()) {
			location += MOVE_LOCATION;
		}
	}

}
