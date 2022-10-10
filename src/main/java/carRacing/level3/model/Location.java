package carRacing.level3.model;

import carRacing.level3.infra.error.IllegalLocationException;
import java.util.Objects;

public class Location {

	private int location;
	private final int MOVE_LOCATION = 1;
	private final int DEFAULT_LOCATION = 0;

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

	public boolean isWinner(int maxLocation) {
		if (location == maxLocation) {
			return true;
		}
		return false;
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
