package racingcar.domain.car;

public class CarName {

	private final String carName;

	private static final int MAX_NAME_LENGTH = 5;

	public CarName(String carName) {
		if (carName == null) {
			throw new IllegalArgumentException();
		}

		if (carName.isBlank() || isTooLong(carName)) {
			throw new IllegalArgumentException("1자 이상 5자 이하로 작성해주세요.");
		}
		this.carName = carName;
	}

	private static boolean isTooLong(String carName) {
		return carName.length() > MAX_NAME_LENGTH;
	}

	public String getName() {
		return carName;
	}
}
