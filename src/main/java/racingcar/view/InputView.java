package racingcar.view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {

	private static final Scanner SCANNER = new Scanner(System.in);

	public int readCarCount() {
		return readInt();
	}

	public int readTrialCount() {
		return readInt();
	}

	private int readInt() {
		try {
			return SCANNER.nextInt();
		} catch (InputMismatchException exception) {
			throw new InputMismatchException("숫자만 입력해야 합니다");
		}
	}
}
