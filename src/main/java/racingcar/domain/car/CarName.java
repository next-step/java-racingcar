package racingcar.domain.car;

public class CarName {

	private final String carName;

	public CarName(String carName) {
		if (carName == null) {
			throw new IllegalArgumentException();
		}
		this.carName = carName;
	}

	public String getName() {
		return carName;
	}
}
