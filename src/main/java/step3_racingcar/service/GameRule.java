package step3_racingcar.service;

import java.util.Random;

public class GameRule {
	private static final Random random = new Random();
	private static final String NEGATIVE_INPUT = "음수입력은 안됩니다";
	private static final String NUMBER_FORMAT = "숫자를 입력하세요";
	private static final int RULE_ARANGE = 10;
	private static final int RULE_FORWARD = 4;

	public static int isAcceptableValue(String inputValue) {
		try {
			int value = Integer.parseInt(inputValue);

			if (value < 0) {
				throw new RuntimeException(NEGATIVE_INPUT);
			}

			return value;

		} catch (NumberFormatException e) {
			throw new RuntimeException(NUMBER_FORMAT);
		}
	}

	public static boolean isCarMoving(int randomValue) {
		return randomValue >= RULE_FORWARD;
	}

	public static int randomValue() {
		return random.nextInt(RULE_ARANGE);
	}

}
