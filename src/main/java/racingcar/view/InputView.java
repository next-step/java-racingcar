package racingcar.view;

import java.util.Scanner;

public class InputView {

	private static final Scanner scanner = new Scanner(System.in);

	public int readCarCount() {
		return scanner.nextInt();
	}

	public int readTrialCount() {
		return scanner.nextInt();
	}
}
