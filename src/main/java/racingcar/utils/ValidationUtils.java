package racingcar.utils;

import java.util.Objects;

public class ValidationUtils {

	public static void validatePositive(int value) {
		if (isNegative(value)) {
			throw new IllegalArgumentException(Message.INVALID_POSITIVE_NUMBER);
		}
	}

	private static boolean isNegative(int value) {
		return value < 0;
	}

	public static void validateEmpty(String text){
		if(Objects.isNull(text) || text.isEmpty()){
			throw new IllegalArgumentException(Message.INVALID_EMPTY_STRING);
		}
	}
}
