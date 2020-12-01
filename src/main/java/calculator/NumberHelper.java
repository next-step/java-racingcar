package calculator;

import java.math.RoundingMode;

public class NumberHelper {

	public Number add(Number addendNumber, Number augendNumber) {
		return new Number(addendNumber.valueOf().add(augendNumber.valueOf()));
	}

	public Number subtract(Number minuendNumber, Number subtrahendNumber) {
		return new Number(minuendNumber.valueOf().subtract(subtrahendNumber.valueOf()));
	}

	public Number multiply(Number multiplierNumber, Number multiplicandNumber) {
		return new Number(multiplierNumber.valueOf().multiply(multiplicandNumber.valueOf()));
	}

	public Number divide(Number dividendNumber, Number divisorNumber) {
		return new Number(dividendNumber.valueOf().divide(divisorNumber.valueOf(), RoundingMode.CEILING));
	}
}
