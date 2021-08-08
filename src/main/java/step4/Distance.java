package step4;

import java.util.Objects;

public class Distance {

	private int distance;

	public Distance(final int distance) {
		this.distance = distance;
	}

	public int getDistance() {
		return distance;
	}

	public Distance getMaxDistance(int maxDistance) {
		return maxDistance > distance ? new Distance(maxDistance) : this;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Distance distance1 = (Distance) o;
		return distance == distance1.distance;
	}

	@Override
	public int hashCode() {
		return Objects.hash(distance);
	}
}
