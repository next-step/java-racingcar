package step4_racingcar_winner.service;

import java.util.Random;

public class GameRule {
	private static final Random random = new Random();
	private static final String NEGATIVE_INPUT = "음수입력은 안됩니다";
	private static final String NUMBER_FORMAT = "숫자를 입력하세요";

	public static int isAcceptableTryValue(String inputValue) {
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

	public static String[] parseNames(String inputValue) {
		String[] names  = inputValue.split(",");

		return names;
	}

}
