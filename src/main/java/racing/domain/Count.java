package racing.domain;

import racing.exception.ErrorMessage;
import racing.exception.NegativeNumberException;

public class Count {

	private int count;

	public Count(int value) {
		if (isNegative(value)) {
			throw new NegativeNumberException(ErrorMessage.POSITIVE_CAN_NOT_BE_NEGATIVE, value);
		}
		this.count = value;
	}

	private boolean isNegative(int value) {
		return value < 0;
	}

	public int getCount() {
		return count;
	}
}
