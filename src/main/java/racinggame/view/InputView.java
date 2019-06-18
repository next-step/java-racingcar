package racinggame.view;

import java.util.Scanner;

public class InputView {
	private static final Scanner scanner = new Scanner(System.in);

	public static int input(String output) {
		System.out.println(output);
		return inputValue(scanner.nextLine());
	}

	private static int inputValue(String number) {
		try {
			return Integer.parseInt(number);
		} catch (NumberFormatException ex) {
			throw new IllegalArgumentException("숫자 형태가 아닙니다. input value : " + number);
		}
	}
}