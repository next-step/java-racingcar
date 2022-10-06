package carRacing.level3.model;

import carRacing.level3.model.strategy.MovingStrategy;

public class Car {

	private static final int DEFAULT_LOCATION = 0;
	private Location location;
	private String carName;

	public Car(String carName) {
		this.location = new Location(DEFAULT_LOCATION);
		this.carName = carName;
	}

	public int carLocation() {
		return location.getLocation();
	}

	public String carName() {
		return carName;
	}

	public void moveLocation(MovingStrategy strategy) {
		if (strategy.isMovable()) {
			location.move();
		}
	}

}
