package carRacing.level3.model;

import carRacing.level3.model.strategy.MovingStrategy;
import java.util.Objects;

public class Car {

	private Location location;
	private CarName carName;

	public Car(String carName) {
		this(new CarName(carName), new Location(0));
	}

	public Car(CarName carName, Location location) {
		this.location = location;
		this.carName = carName;
	}

	public Location carLocation() {
		return location;
	}

	public String carName() {
		return carName.Name();
	}

	public void moveLocation(MovingStrategy strategy) {
		if (strategy.isMovable()) {
			location.move();
		}
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Car car = (Car) o;
		return Objects.equals(location, car.location) && Objects.equals(carName,
			car.carName);
	}

	@Override
	public int hashCode() {
		return Objects.hash(location, carName);
	}

	public boolean isMaxLocation(Location maxLocation) {

		if (location.equals(maxLocation)) {
			return true;
		}
		return false;
	}
}
