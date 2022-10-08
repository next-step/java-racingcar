package step4.model;

public class CarName {
	private static final int MAX_NAME_LENGTH = 5;

	private final String carName;

	public CarName(String carName) {
		checkNameCondition(carName);
		this.carName = carName;
	}

	public String getCarName() {
		return carName;
	}

	void checkNameCondition(String carName) {
		if (carName.length() > MAX_NAME_LENGTH || carName.isBlank()) {
			throw new IllegalArgumentException("이름의 길이는 적어도 1자 이상 5자 이하이어야 합니다.");
		}
	}
}
