package racingcar.view;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class InputView {

	private static final String NAME_DELIMITER = ",";
	private static final Scanner SCANNER = new Scanner(System.in);

	public int readCarCount() {
		return readPositive();
	}

	public int readTrialCount() {
		return readPositive();
	}

	public List<String> readNames() {
		String input = SCANNER.nextLine();
		String[] names = input.split(NAME_DELIMITER);
		return List.of(names);
	}

	private int readPositive() {
		int input = readInt();
		if (input <= 0) {
			throw new InputMismatchException("양수를 입력해야 합니다");
		}
		return input;
	}

	private int readInt() {
		try {
			return SCANNER.nextInt();
		} catch (InputMismatchException exception) {
			throw new InputMismatchException("정수를 입력해야 합니다");
		}
	}
}
