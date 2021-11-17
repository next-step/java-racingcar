package study.racingcar.view;

import java.util.Scanner;

public class InputView {

	private static final String CAR_COUNT_MESSAGE = "자동차 대수는 몇 대 인가요?";
	private static final String GAME_COUNT_MESSAGE = "시도할 회수는 몇 회 인가요?";
	private static final String ONLY_INPUT_NUMBER_MESSAGE = "숫자만 입력해주세요.";

	private static final Scanner scanner = new Scanner(System.in);

	private InputView() {
		throw new AssertionError();
	}

	public static int inputCarCountByUser() {
		System.out.println(CAR_COUNT_MESSAGE);
		return inputIntByUser();
	}

	public static int inputGameRoundByUser() {
		System.out.println(GAME_COUNT_MESSAGE);
		return inputIntByUser();
	}

	private static int inputIntByUser( ) {
		String value = inputStringByUser();
		checkStringNumber(value);
		return Integer.parseInt(value);
	}

	private static String inputStringByUser() {
		return scanner.nextLine();
	}

	private static void checkStringNumber(String number) {
		boolean isNumeric = number.chars().allMatch(Character::isDigit);
		if (!isNumeric) {
			throw new IllegalArgumentException(ONLY_INPUT_NUMBER_MESSAGE);
		}
	}

}
