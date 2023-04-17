package step4_racingcar_winner.service;

import java.util.Random;

public class GameRule {
	private static final Random random = new Random();
	private static final String NEGATIVE_INPUT = "음수입력은 안됩니다";
	private static final String NUMBER_FORMAT = "숫자를 입력하세요";
	private static final String NULL_EMPTY = "널이거나 빈값입니다";
	private static final String NAMINGRULE = "자동차 이름을 길게 작성했습니다 ";

	private static final int RULE_ARANGE = 10;
	private static final int RULE_FORWARD = 4;
	private static final int RULE_NAME_LENGTH_MAX = 5;

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

	public static String[] isAcceptableName(String inputValue) {
		String[] names  = inputValue.split(",");

		for(String name : names)
		{
			isNameLengthAcceptable(name);
		}

		return names;
	}

	public static void isNameLengthAcceptable(String name)
	{
		if(name == null || name.isBlank())
		{
			throw new RuntimeException(NULL_EMPTY);
		}

		if(RULE_NAME_LENGTH_MAX < name.length() )
		{
			throw new RuntimeException(NAMINGRULE);
		}
	}

	public static boolean isCarMoving(int randomValue) {
		return randomValue >= RULE_FORWARD;
	}

	public static int randomValue() {
		return random.nextInt(RULE_ARANGE);
	}

}
