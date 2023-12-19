package racingcar.util;

import java.util.Scanner;

public class Input {
	public static int inputValue() {
		Scanner scanner = new Scanner(System.in);
		String inputValue = scanner.nextLine();
		validateInput(inputValue);
		return Integer.parseInt(inputValue);
	}

	public static String[] inputNames() {
		Scanner scanner = new Scanner(System.in);
		String inputNames = scanner.nextLine();
		validateInput(inputNames);
		return inputNames.split(",");
	}

	public static void validateInput(String input) {
		if (input.isBlank()) {
			throw new RuntimeException("입력값이 없습니다.");
		}
	}
}
