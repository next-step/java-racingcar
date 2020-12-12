package edu.nextstep.racing.domain;

import java.util.Objects;
import java.util.function.Supplier;

public class Location implements Comparable {
	private final int location;

	public Location(int location) {
		if (location < 0) {
			throw new IllegalArgumentException("location은 0 이상이어야 합니다.");
		}
		this.location = location;
	}

	public Location move(Supplier<Boolean> movable) {
		if (movable.get()) {
			return new Location(location + 1);
		}
		return this;
	}

	public int getValue() {
		return location;
	}

	@Override
	public int compareTo(Object o) {
		return location - ((Location)o).location;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof Location)) {
			return false;
		}
		Location location1 = (Location)o;
		return location == location1.location;
	}

	@Override
	public int hashCode() {
		return Objects.hash(location);
	}
}
