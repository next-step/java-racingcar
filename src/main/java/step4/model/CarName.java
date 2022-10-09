package step4.model;

import java.util.Objects;

public class CarName {
	private static final int MAX_NAME_LENGTH = 5;

	private final String carName;

	public CarName(final String carName) {
		checkNameCondition(carName);
		this.carName = carName;
	}

	public String getCarName() {
		return carName;
	}

	void checkNameCondition(final String carName) {
		if (carName.length() > MAX_NAME_LENGTH || carName.isBlank()) {
			throw new IllegalArgumentException("이름의 길이는 적어도 1자 이상 5자 이하이어야 합니다.");
		}
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		CarName carName1 = (CarName) o;
		return Objects.equals(carName, carName1.carName);
	}

	@Override
	public int hashCode() {
		return Objects.hash(carName);
	}
}
