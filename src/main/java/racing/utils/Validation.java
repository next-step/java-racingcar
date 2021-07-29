package racing.utils;

public class Validation {

	private static final String INT_REG_EXP = "^\\d+$";

	public static void validEmptyCheck(String value, String errorMessage) {
		if (value.isEmpty()) {
			throw new IllegalArgumentException(errorMessage);
		}
	}

	public static void validIntTypeMatchCheck(String value, String errorMessage) {
		if (!value.matches(INT_REG_EXP)) {
			throw new IllegalArgumentException(errorMessage);
		}
	}

	public static void validStringLength(String value, int checkLength, String errorMessage) {
		if (value.length() > checkLength) {
			throw new IllegalArgumentException(errorMessage);
		}
	}

	public static void validPositiveCheck(int position, String positiveCheckMessage) {
		if (position < 0) {
			throw new IllegalArgumentException(positiveCheckMessage);
		}
	}

	public static void validRandomRangeCheck(int randomValue, String numberRangeCheckMessage) {
		if (randomValue < 0 || randomValue > 9) {
			throw new IllegalArgumentException(numberRangeCheckMessage);
		}
	}

}
