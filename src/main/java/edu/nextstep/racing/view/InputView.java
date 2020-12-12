package edu.nextstep.racing.view;

import java.util.Scanner;
import java.util.regex.Pattern;

public class InputView {
	public static Scanner scanner = new Scanner(System.in);

	private InputView() {
	}

	public static int inputNumberOfCars() {
		System.out.println("자동차 대수는 몇 대 인가요?");
		String input = scanner.nextLine();
		if (!Pattern.matches("^[0-9]+$", input)) {
			return inputNumberOfCars();
		}
		return Integer.parseInt(input);
	}

	public static int inputMoveTryMaxCount() {
		System.out.println("시도할 회수는 몇 회 인가요?");
		String input = scanner.nextLine();
		if (!Pattern.matches("^[0-9]+$", input)) {
			return inputMoveTryMaxCount();
		}
		return Integer.parseInt(input);
	}

	public static String[] inputNameOfCars() {
		System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
		String input = scanner.nextLine();
		if (!isValidInput(input)) {
			return inputNameOfCars();
		}
		return input.split(",");
	}

	public static boolean isValidInput(String input) {
		if (input == null) {
			return false;
		}
		return Pattern.matches("[^,\\s]{1,5}(,[^,\\s]{1,5})*", input);
	}
}