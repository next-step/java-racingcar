package racingcar.view;

import java.util.Scanner;

public class InputView {

	private static final Scanner SCANNER = new Scanner(System.in);

	public int readCarCount() {
		return SCANNER.nextInt();
	}

	public int readTrialCount() {
		return SCANNER.nextInt();
	}
}
