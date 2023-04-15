package carRacing.domain;

import java.util.Objects;

import carRacing.strategy.MoveStrategy;

public class Car {

	private static final int MOVE_CONDITION_MINIMUM = 4;

	private final Name name;
	private final Location location;

	public Car(Name name, Location location) {
		this.name = name;
		this.location = location;
	}

	public void move(int randomValue) {
		if (this.movable(randomValue)) {
			this.location.plus();
		}
	}

	private boolean movable(int randomValue) {
		MoveStrategy moveStrategy = () -> randomValue >= MOVE_CONDITION_MINIMUM;
		return moveStrategy.movable();
	}

	public int greaterLocation(int bestLocation) {
		if (this.location.isGreater(bestLocation)) {
			bestLocation = this.location.getLocation();
		}
		return bestLocation;
	}

	public boolean isBestLocation(int bestLocation) {
		return this.location.isEqual(bestLocation);
	}

	public Name getName() {
		return this.name;
	}

	public Location getLocation() {
		return this.location;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Car car = (Car)o;
		return location.equals(car.location);
	}

	@Override
	public int hashCode() {
		return Objects.hash(location);
	}
}
