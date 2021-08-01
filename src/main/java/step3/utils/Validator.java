package step3.utils;

public class Validator {
	public static void validateOverZero(int number) {
		if (number < 1) {
			throw new IllegalArgumentException("0보다 큰 숫자를 입력해주세요!");
		}
	}
}
