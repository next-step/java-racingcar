package calculator;

public class NumberFactorHelper {

	public static boolean isNumberFactor(String value) {
		try {
			Integer.parseInt(value);
		} catch (NumberFormatException numberFormatException) {
			return false;
		}
		return true;
	}

	public static NumberFactor add(InputFactor<Integer> addendNumber, InputFactor<Integer> augendNumber) {
		return wrapperNumberFactor(addendNumber.valueOfFactor() + augendNumber.valueOfFactor());
	}

	public static NumberFactor subtract(InputFactor<Integer> minuendNumber, InputFactor<Integer> subtrahendNumber) {
		return wrapperNumberFactor(minuendNumber.valueOfFactor() - subtrahendNumber.valueOfFactor());
	}

	public static NumberFactor multiply(InputFactor<Integer> multiplierNumber, InputFactor<Integer> multiplicandNumber) {
		return wrapperNumberFactor(Math.multiplyExact(multiplierNumber.valueOfFactor(), multiplicandNumber.valueOfFactor()));
	}

	public static NumberFactor divide(InputFactor<Integer> dividendNumber, InputFactor<Integer> divisorNumber) {
		return wrapperNumberFactor(Math.floorDiv(dividendNumber.valueOfFactor(), divisorNumber.valueOfFactor()));
	}

	private static NumberFactor wrapperNumberFactor(int value) {
		return new NumberFactor(value);
	}
}
