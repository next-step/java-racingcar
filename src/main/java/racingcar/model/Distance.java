package racingcar.model;

import java.util.Objects;

public class Distance {
	private int distance;

	public Distance() {
		this(0);
	}

	public Distance(int distance) {
		if (distance < 0) {
			throw new IllegalArgumentException("distance는 음수 값을 가질 수 없습니다.");
		}
		this.distance = distance;
	}

	public int distance() {
		return distance;
	}

	public void move() {
		distance++;
	}

	public boolean compareTo(Distance o){
		return this.distance < o.distance;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Distance distance1 = (Distance)o;
		return distance == distance1.distance;
	}

	@Override
	public int hashCode() {
		return Objects.hash(distance);
	}
}
