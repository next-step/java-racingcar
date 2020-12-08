package step3;

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
}