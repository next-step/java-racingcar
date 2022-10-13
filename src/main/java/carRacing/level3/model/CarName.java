package carRacing.level3.model;

import carRacing.level3.exception.NameLengthException;

public class CarName {

	private static final int MAX_LENGTH = 5;
	private String carName;

	public CarName(String carName) {
		if (carName.length() > MAX_LENGTH) {
			throw new NameLengthException("자동차 이름이 제한 길이를 초과하였습니다");
		}
		this.carName = carName;
	}

	public String Name() {
		return carName;
	}
}
