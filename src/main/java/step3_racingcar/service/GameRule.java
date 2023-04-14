package step3_racingcar.service;

import java.util.Random;

public class GameRule {
	private static final Random random = new Random();
	private static final String ERRMSG_negativeInput = "음수입력은 안됩니다";
	private static final String ERRMSG_numberFormat = "숫자를 입력하세요";
	private static final int RULE_ARANGE = 10;
	private static final int RULE_FORWARD = 4;

	public static int isAcceptableValue(String inputValue) {
		try {
			int value = Integer.parseInt(inputValue);

			if (value < 0) {
				throw new RuntimeException(ERRMSG_negativeInput);
			}

			return value;

		} catch (NumberFormatException e) {
			throw new RuntimeException(ERRMSG_numberFormat);
		}
	}

	public static boolean isCarMoving() {
		int randomValue = random.nextInt(RULE_ARANGE);
		return randomValue >= RULE_FORWARD;
	}

}
