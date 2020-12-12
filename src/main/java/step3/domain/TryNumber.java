package step3.domain;

import step3.utils.ValidationUtils;

public class TryNumber {
	private int number;

	public TryNumber(int number) {
		ValidationUtils.validPositive(number);
		this.number = number;
	}

	public void play() {
		if (number > 0) {
			number--;
		}
	}

	public boolean playing() {
		return number > 0;
	}
}
