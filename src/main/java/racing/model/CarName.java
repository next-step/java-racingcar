package racing.model;

import racing.util.StringValid;

public class CarName {

	public static final int CAR_NAME_MAX_LENGTH = 5;
	private final String name;

	public CarName(String carName) {

		this.name = setCarName(carName);
	}

	private String setCarName(String carName) {

		validationCarName(carName);

		return carName;
	}

	private void validationCarName(String carName) {

		if (StringValid.isEmptyStr(carName)) {
			throw new IllegalArgumentException("차량 이름이 없습니다.");
		}

		if (carName.length() > CAR_NAME_MAX_LENGTH) {
			throw new IllegalArgumentException("차량 이름은 최대 5자를 초과할 수 없습니다.");
		}
	}

	public String getName() {

		return this.name;
	}

}
