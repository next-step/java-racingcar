package racingcar;

import java.util.Scanner;

public class InputView {

	private static final String INPUT_CAR_NAMES_TEXT = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
	private static final String INPUT_COUNT_TEXT = "시도할 회수는 몇 회 인가요?";
	private static final Scanner INPUT_VALUE = new Scanner(System.in);

	private static void inputCarNamesQuestion() {
		print(INPUT_CAR_NAMES_TEXT);
	}

	private static void inputCountQuestion() {
		print(INPUT_COUNT_TEXT);
	}

	public static String[] inputCarNames(final String inputNames) {
		return inputNames.split(",");
	}

	public static Integer inputCount(final Integer inputCount) {
		return inputCount;
	}

	private static void print(final String text) {
		System.out.println(text);
	}

	public static InputDto getCountAndCarNames() {
		inputCarNamesQuestion();
		String[] carNames = inputCarNames(INPUT_VALUE.nextLine());
		inputCountQuestion();
		int count = inputCount(INPUT_VALUE.nextInt());

		return new InputDto(count, carNames);
	}
}
