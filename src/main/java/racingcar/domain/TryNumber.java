package racingcar.domain;

import racingcar.utils.ValidationUtils;

public class TryNumber {
	private int number;

	public TryNumber(int number) {
		ValidationUtils.validatePositive(number);
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
