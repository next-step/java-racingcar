package racingcar.step3;

public class InputValidator {

	public static final int MINIMUM_INPUT_NUMBER = 1;

	public void isNumber(String value) {
		try {
			Integer.parseInt(value);
		} catch (NumberFormatException e) {
			throw new NumberFormatException("숫자를 입력해주세요.");
		}
	}

	public void isNegative(String value) {
		if (Integer.parseInt(value) < MINIMUM_INPUT_NUMBER) {
			throw new NumberFormatException("1이상의 수를 입력해주세요.");
		}
	}
}
