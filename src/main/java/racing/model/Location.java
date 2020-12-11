package racing.model;

import java.util.Objects;

public class Location {

	private int location;

	public Location() {

		this(0);
	}

	public Location(int carLocation) {

		if (carLocation < 0) {
			throw new IllegalArgumentException("자동차 Location 값은 항상 0보다 같거나 커야합니다.");
		}

		this.location = carLocation;
	}

	// Mutable 객체 vs Immutable 객체
	// 객체를 생성한 후 필드를 변경 유무로 판단
	// Immutable : 객체 생성 후 필드 값을 변경 못하도록 하여, 보다 안전하게 관리할 수 있는 객체 형태
	public void move() {

		// return this;
		// 단점: move() 메서드가 실행 될 때마다, 계속 객체가 생성되는 비효율이 발생하여 속도 저하
		//return new Location(this.location + 1);
		this.location += 1;
	}

	public int getDistance() {
		return this.location;
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
