package step5_racingcar_refactoring.service;

public class GameRule {
	private static final String NEGATIVE_INPUT = "음수입력은 안됩니다";
	private static final String NUMBER_FORMAT = "숫자를 입력하세요";

	public static int isAcceptableTryValue(String inputValue) {

		int value;

		try {
			 value = Integer.parseInt(inputValue);
		} catch (NumberFormatException e) {
			throw new RuntimeException(NUMBER_FORMAT);
		}

		if (value < 0) {
			throw new RuntimeException(NEGATIVE_INPUT);
		}

		return value;
	}

	public static String[] parseNames(String inputValue) {
		return inputValue.split(",");
	}

}
