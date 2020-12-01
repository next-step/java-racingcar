package calculator;

public class NumberHelper {

	public Number add(Number one, Number two) {
		return new Number(one.getValue() + two.getValue());
	}

	public Number subtract(Number baseNumber, Number addendNumber) {
		return new Number(baseNumber.getValue() - addendNumber.getValue());
	}

	public Number multiply(Number baseNumber, Number addendNumber) {
		return new Number(baseNumber.getValue() * addendNumber.getValue());
	}
}
