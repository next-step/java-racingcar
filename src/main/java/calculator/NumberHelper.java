package calculator;

public class NumberHelper {

	public Number add(Number baseNumber, Number addendNumber) {
		return new Number(baseNumber.getValue() + addendNumber.getValue());
	}

	public Number subtract(Number baseNumber, Number addendNumber) {
		return new Number(baseNumber.getValue() - addendNumber.getValue());
	}

	public Number multiply(Number baseNumber, Number addendNumber) {
		return new Number(baseNumber.getValue() * addendNumber.getValue());
	}

	public Number divide(Number baseNumber, Number addendNumber) {
		return new Number(baseNumber.getValue() / addendNumber.getValue());
	}
}
