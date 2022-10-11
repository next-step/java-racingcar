package carRacing.level3.model;

import carRacing.level3.model.strategy.MovingStrategy;
import java.util.Objects;

public class Car {

	private Location location;
	private CarName carName;

	public Car(String carName) {
		this(carName,0);
	}

	public Car(String carName,int location){
		this.location = new Location(location);
		this.carName = new CarName(carName);
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
}
