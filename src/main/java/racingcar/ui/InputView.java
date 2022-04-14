package racingcar.ui;

import java.util.Scanner;

import calculator.Parser;

public class InputView {
	private static final String CAR_COUNT_MESSAGE = "자동차 대수는 몇 대 인가요?";
	private static final String TRY_COUNT_MESSAGE = "시도할 회수는 몇 회 인가요?";
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
