package carRacing.domain;

import java.util.Objects;

import carRacing.strategy.MoveStrategy;

public class Car {

	private static final int MOVE_CONDITION_MINIMUM = 4;

	private final Location location;

	public Car(Location location) {
		this.location = location;
	}

	public void move(int randomValue) {
		if (this.movable(randomValue)) {
			location.plus();
		}
	}

	private boolean movable(int randomValue) {
		MoveStrategy moveStrategy = () -> randomValue >= MOVE_CONDITION_MINIMUM;
		return moveStrategy.movable();
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
