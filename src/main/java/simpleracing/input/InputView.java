package simpleracing.input;

import java.util.Scanner;

public class InputView {

	public static CarRacingInitValue input() {
		Scanner scanner = new Scanner(System.in);
		CarRacingInitValue initValue = initGame(scanner);
		scanner.close();

		return initValue;
	}

	private static CarRacingInitValue initGame(Scanner scanner) {
		CarRacingInitValue initValue = new CarRacingInitValue();

		for (InputType inputType : InputType.values()) {
			System.out.println(inputType.getQuestion());
			inputType.setInit(initValue, scanner.nextLine());
		}

		return initValue;
	}
}
