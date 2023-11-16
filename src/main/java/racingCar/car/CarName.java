package racingCar.car;

public class CarName {
	private final String carName;

	public CarName(String carName) {
		validate(carName);
		this.carName = carName;
	}

	private void validate(String carName) {
		if (carName.length() > 5) {
			throw new RuntimeException("자동차 이름은 5자를 초과할 수 없습니다.");
		}
	}

	public String carName() {
		return carName;
	}
}
