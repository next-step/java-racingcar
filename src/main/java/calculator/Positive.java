package calculator;

import calculator.exception.ErrorMessage;
import calculator.exception.NegativeNumberException;

public class Positive {

	private int number;

	public Positive(String value) {
		this(Integer.parseInt(value));
	}

	public Positive(int value) {
		if (isNegative(value)) {
			throw new NegativeNumberException(ErrorMessage.POSITIVE_CAN_NOT_BE_NEGATIVE, value);
		}
		this.number = value;
	}

	private boolean isNegative(int number) {
		return number < 0;
	}

	public int getNumber() {
		return number;
	}

	@Override
	public String toString() {
		return "Positive{" +
			"number=" + number +
			'}';
	}
}
