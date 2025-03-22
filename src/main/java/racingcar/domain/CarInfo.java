package racingcar.domain;

public record CarInfo(
	String name,
	int location
) {
	CarInfo(Car car) {
		this(
			car.getName(),
			car.getLocation()
		);
	}

	public boolean isSameLocation(int compareLocation) {
		return compareLocation == location;
	}
}
