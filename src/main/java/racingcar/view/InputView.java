package racingcar.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import calculator.Parser;
import racingcar.domain.CarName;
import racingcar.domain.CarNames;

public class InputView {
	private static final String CAR_COUNT_MESSAGE = "자동차 대수는 몇 대 인가요?";
	private static final String CAR_NAMES_COMMA_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
	private static final String TRY_COUNT_MESSAGE = "시도할 회수는 몇 회 인가요?";
	public static final String CAR_NAME_SPLIT_REGEX = ",";
	private static final Scanner scanner = new Scanner(System.in);

	private InputView() {}

	public static int inputCarCount() {
		System.out.println(CAR_COUNT_MESSAGE);
		try {
			return Parser.toInt(inputLine());
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return inputCarCount();
		}
	}

	public static CarNames inputCarNames() {
		System.out.println(CAR_NAMES_COMMA_MESSAGE);
		try {
			return new CarNames(inputLine().split(CAR_NAME_SPLIT_REGEX));
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return inputCarNames();
		}
	}

	public static int inputPlayCount() {
		System.out.println(TRY_COUNT_MESSAGE);

		try {
			return Parser.toInt(inputLine());
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return inputPlayCount();
		}
	}

	private static String inputLine() {
		return scanner.nextLine();
	}
}
