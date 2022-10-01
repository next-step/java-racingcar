package racingcar.view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {

	private static final Scanner SCANNER = new Scanner(System.in);

	public int readCarCount() {
		return readPositive();
	}

	public int readTrialCount() {
		return readPositive();
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
