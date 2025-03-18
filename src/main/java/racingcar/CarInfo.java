package racingcar;

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
}
