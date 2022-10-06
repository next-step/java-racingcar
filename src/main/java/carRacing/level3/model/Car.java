package carRacing.level3.model;

import carRacing.level3.model.strategy.MovingStrategy;

public class Car {

	private Location location;
	private CarName carName;

	public Car(String carName) {
		this.location = new Location();
		this.carName = new CarName(carName);
	}

	public int carLocation() {
		return location.getLocation();
	}

	public String carName() {
		return carName.Name();
	}

	public void moveLocation(MovingStrategy strategy) {
		if (strategy.isMovable()) {
			location.move();
		}
	}

}
