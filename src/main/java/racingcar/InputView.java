package racingcar;

import java.util.Scanner;

public class InputView {

	public static final Scanner INPUT_VALUE = new Scanner(System.in);
	public static final String INPUT_CAR_NUMBER_TEXT = "자동차 대수는 몇 대 인가요?";
	public static final String INPUT_COUNT_TEXT = "시도할 회수는 몇 회 인가요?";

	public static Scanner inputCarNumber() {
		print(INPUT_CAR_NUMBER_TEXT);
		return INPUT_VALUE;
	}

	public static Scanner inputCount() {
		print(INPUT_COUNT_TEXT);
		return INPUT_VALUE;
	}

	private static void print(final String text) {
		System.out.println(text);
	}
}
