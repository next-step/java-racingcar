package edu.nextstep.racing.domain.game.cars.car;

import java.util.Objects;
import java.util.function.BooleanSupplier;

public class Location implements Comparable<Location> {
	private final int location;

	public Location(int location) {
		if (location < 0) {
			throw new IllegalArgumentException("location은 0 이상이어야 합니다.");
		}
		this.location = location;
	}

	public Location move(BooleanSupplier movable) {
		if (movable.getAsBoolean()) {
			return new Location(location + 1);
		}
		return this;
	}

	public int getValue() {
		return location;
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

	@Override
	public int compareTo(Location other) {
		return location - other.location;
	}
}
