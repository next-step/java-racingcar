package racingrefactoring.domain;

import java.util.Arrays;

public class CarValidator {

	private static final int NAME_LENGTH_LIMIT = 5;

	private CarValidator() {
		throw new IllegalStateException();
	}

	public static boolean isValidName(String name) {
		return name.length() <= NAME_LENGTH_LIMIT;
	}

	public static boolean isInvalidName(String name) {
		return !isValidName(name);
	}

	public static boolean hasValidNames(String[] names) {
		return Arrays.stream(names).noneMatch(name -> name.length() > NAME_LENGTH_LIMIT);
	}

	public static boolean hasInvalidName(String[] names) {
		return !hasValidNames(names);
	}

}
