package carRacing.level3.model;

import java.util.Objects;

public class Location {

	private int location;
	private final int MOVE_LOCATION = 1;

	public Location(){
		this(0);
	}

	public Location(int location) {
		if(location < 0){
			throw new RuntimeException();
		}
		this.location = location;
	}

	public int getLocation() {
		return location;
	}

	public Location move() {
		location += MOVE_LOCATION;
		return new Location(location);
	}


	public boolean isWinner(int maxLocation) {
		if(location == maxLocation){
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
