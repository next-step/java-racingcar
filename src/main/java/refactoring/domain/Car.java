package refactoring.domain;

import strategy.Moveable;

public class Car {

	private final CarName carName;
	private final CarDistance carDistance;

	public Car(String name) {
		this(name, new CarDistance());
	}

	private Car(String name, CarDistance carDistance) {
		this.carName = new CarName(name);
		this.carDistance = carDistance;
	}

	public String getCarName() {
		return carName.getName();
	}

	public int getCarDistance() {
		return carDistance.getDistance();
	}

	public boolean sameWinnerCarDistance(Car car) {
		return this.carDistance.equals(car.carDistance);
	}

	public void move(Moveable moveable) {
		if (moveable.isMoveable()) {
			carDistance.increaseDistance();
		}
	}
}
