package racingcar;

import java.util.Scanner;

public class InputView {

	private static final Scanner INPUT_VALUE = new Scanner(System.in);
	private static final String INPUT_CAR_NAMES_TEXT = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
	private static final String INPUT_COUNT_TEXT = "시도할 회수는 몇 회 인가요?";

	public static String[] inputCarNames() {
		print(INPUT_CAR_NAMES_TEXT);
		return INPUT_VALUE.nextLine().split(",");
	}

	public static Integer inputCount() {
		print(INPUT_COUNT_TEXT);
		return INPUT_VALUE.nextInt();
	}

	private static void print(final String text) {
		System.out.println(text);
	}
}
