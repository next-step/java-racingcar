package carRacing.level3.model;

import carRacing.level3.exception.IllegalLocationException;
import java.util.List;
import java.util.Objects;

public class Location {


	private static final int MOVE_LOCATION = 1;
	private static final int DEFAULT_LOCATION = 0;
	private static int maxLocation;
	private int location;


	public Location() {
		this(0);
	}

	public Location(int location) {
		if (location < DEFAULT_LOCATION) {
			throw new IllegalLocationException("위치는 음수가 될 수 없습니다");
		}
		this.location = location;
	}

	public int getLocation() {
		return location;
	}

	public void move() {
		location += MOVE_LOCATION;
	}

	public Location maxLocation(List<Car> cars) {
		for (int i = 0; i < cars.size(); i++) {
			compareLocation(cars.get(i).carLocation());
		}
		return new Location(maxLocation);
	}

	private void compareLocation(Location carLocation) {
		if (maxLocation < carLocation.getLocation()) {
			maxLocation = carLocation.getLocation();
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
		Location location1 = (Location) o;
		return location == location1.location && MOVE_LOCATION == location1.MOVE_LOCATION;
	}

	@Override
	public int hashCode() {
		return Objects.hash(location, MOVE_LOCATION);
	}


}
