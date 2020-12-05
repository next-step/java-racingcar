package step2;

import java.util.regex.Pattern;

public class InterfaceUtil {

	public static String[] parseInput(String input) {
		checkEmpty(input);
		checkCorrectCharacter(input);
		return input.split(" ");
	}

	public static void checkEmpty(String input) {
		if (input == null || input.equals("")) {
			throw new IllegalArgumentException();
		}
	}

	public static void checkCorrectCharacter(String input) {
		String[] splitString = input.split(" ");
		if (splitString.length < 3 || splitString.length % 2 == 0) {
			throw new IllegalArgumentException("연산의 짝을 맞춰주세요.");
		}
		for (int i = 0; i < splitString.length; i += 2) {
			matchRegExpOrException("[0-9]+", splitString[i]);
		}
		for (int i = 1; i < splitString.length; i += 2) {
			matchRegExpOrException("[*+/-]", splitString[i]);
		}
	}

	public static void matchRegExpOrException(String regExp, String str) {
		if (!Pattern.matches(regExp, str)) {
			throw new IllegalArgumentException("사칙연산을 하기 위한 올바른 입력이 아닙니다.");
		}
	}
}
