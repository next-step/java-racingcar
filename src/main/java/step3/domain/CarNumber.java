package step3.domain;

import step3.utils.ValidationUtils;

public class CarNumber {
	private final int number;

	public CarNumber(int number) {
		ValidationUtils.validPositive(number);
		this.number = number;
	}

	public int getNumber() {
		return number;
	}
}
