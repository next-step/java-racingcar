package step3.utils;

public class ValidationUtils {

	public static void validPositive(int value) {
		if (isNegative(value)) {
			throw new IllegalArgumentException(Message.INVALID_POSITIVE_NUMBER);
		}
	}

	private static boolean isNegative(int value) {
		return value < 0;
	}
}
