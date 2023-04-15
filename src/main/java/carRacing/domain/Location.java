package carRacing.domain;

import java.util.Objects;

public class Location {

	private int location;

	public Location(int location) {
		this.location = location;
	}

	public void plus() {
		this.location++;
	}

	public int getLocation() {
		return this.location;
	}

	public boolean isEqual(int location) {
		return this.location == location;
	}

	public boolean isGreater(int location) {
		return this.location > location;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Location location1 = (Location)o;
		return location == location1.location;
	}

	@Override
	public int hashCode() {
		return Objects.hash(location);
	}
}
