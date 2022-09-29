package racingcar.step3_4;

public class InputValidator {

	public static final int MINIMUM_INPUT_NUMBER = 1;

	public void isZeroOrNegative(int value) {
		if (value < MINIMUM_INPUT_NUMBER) {
			throw new NumberFormatException("1이상의 수를 입력해주세요.");
		}
	}

	public void isBlank(String value) {
		if (value == null || value.isBlank()) {
			throw new IllegalArgumentException("1자 이상의 이름을 입력해주세요");
		}
	}
}
