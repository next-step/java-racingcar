package carRacing.level3.model;

public class Location {

	private int location;
	private final int MOVE_LOCATION = 1;

	public Location(int location) {
		this.location = location;
	}

	public int getLocation() {
		return location;
	}

	public Location move() {
		location += MOVE_LOCATION;
		return new Location(location);
	}
}
