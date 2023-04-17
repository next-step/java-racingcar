package racing.car.domain;

import java.util.Objects;

import racing.car.strategy.MoveStrategy;

public class Car {

	private static final int MOVE_CONDITION_MINIMUM = 4;

	private final Name name;
	private final Location location;

	public Car(String name, int location) {
		this.name = new Name(name);
		this.location = new Location(location);
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

	public Location greaterLocation(Location bestLocation) {
		if (this.location.isGreater(bestLocation)) {
			bestLocation = this.location;
		}
		return bestLocation;
	}

	public boolean isWinner(Location bestLocation) {
		return this.location.equals(bestLocation);
	}

	public String getName() {
		return this.name.getName();
	}

	public int getLocation() {
		return this.location.getLocation();
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
