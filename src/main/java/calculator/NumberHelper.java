package calculator;

import java.math.RoundingMode;

public class NumberHelper {

	public Number add(Number baseNumber, Number addendNumber) {
		return new Number(baseNumber.valueOf().add(addendNumber.valueOf()));
	}

	public Number subtract(Number baseNumber, Number addendNumber) {
		return new Number(baseNumber.valueOf().subtract(addendNumber.valueOf()));
	}

	public Number multiply(Number baseNumber, Number addendNumber) {
		return new Number(baseNumber.valueOf().multiply(addendNumber.valueOf()));
	}

	public Number divide(Number baseNumber, Number addendNumber) {
		return new Number(baseNumber.valueOf().divide(addendNumber.valueOf(), RoundingMode.CEILING));
	}
}
