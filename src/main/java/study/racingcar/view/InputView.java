package study.racingcar.view;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputView {

	private static final String CAR_COUNT_MESSAGE = "자동차 대수는 몇 대 인가요?";
	private static final String GAME_COUNT_MESSAGE = "시도할 회수는 몇 회 인가요?";
	private static final String ONLY_INPUT_NUMBER_MESSAGE = "숫자만 입력해주세요.";
	private static final String CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
	private static final String SEPARATOR = ",";
	private static final String INPUT_CAR_NAMES_SEPARATOR_ERROR_MESSAGE = "구분자는 쉼표(,)를 사용해주세요.";

	private static final Scanner scanner = new Scanner(System.in);

	private InputView() {
		throw new AssertionError();
	}

	public static int inputCarCountByUser() {
		System.out.println(CAR_COUNT_MESSAGE);
		return inputIntByUser();
	}

	public static List<String> inputCarNamesByUser() {
		System.out.println(CAR_NAMES_MESSAGE);
		return inputListByUser();
	}

	private static List<String> inputListByUser() {
		String value = inputStringByUser();
		checkStringSplitSeparator(value);
		return Stream.of(value.split(","))
					.map(String::trim)
					.collect(Collectors.toList());
	}

	private static void checkStringSplitSeparator(String value) {
		if(!value.contains(SEPARATOR)){
			throw new IllegalArgumentException(INPUT_CAR_NAMES_SEPARATOR_ERROR_MESSAGE);
		}
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
