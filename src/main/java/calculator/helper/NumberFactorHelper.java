package calculator.helper;

import calculator.InputFactor;
import calculator.NumberFactor;

public class NumberFactorHelper {

	public static boolean isNumeric(String checkNumber) {
		if (checkNumber == null) {
			return false;
		}
		try {
			Double.parseDouble(checkNumber);
		} catch (NumberFormatException numberFormatException) {
			return false;
		}
		return true;
	}

	public static NumberFactor add(InputFactor<Integer> addendNumber, InputFactor<Integer> augendNumber) {

		return wrapperNumberFactor(Math.addExact(addendNumber.valueOfFactor(), augendNumber.valueOfFactor()));
	}

	public static NumberFactor subtract(InputFactor<Integer> minuendNumber, InputFactor<Integer> subtrahendNumber) {
		return wrapperNumberFactor(minuendNumber.valueOfFactor() - subtrahendNumber.valueOfFactor());
	}

	public static NumberFactor multiply(InputFactor<Integer> multiplierNumber, InputFactor<Integer> multiplicandNumber) {
		return wrapperNumberFactor(Math.multiplyExact(multiplierNumber.valueOfFactor(), multiplicandNumber.valueOfFactor()));
	}

	public static NumberFactor divide(InputFactor<Integer> dividendNumber, InputFactor<Integer> divisorNumber) {
		return wrapperNumberFactor(dividendNumber.valueOfFactor() / divisorNumber.valueOfFactor());
	}

	private static NumberFactor wrapperNumberFactor(int value) {
		return new NumberFactor(value);
	}
}
