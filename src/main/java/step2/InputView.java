package step2;

import java.util.Scanner;

public class InputView {

	public UserInput getUserInput() {
		Scanner scanner = new Scanner(System.in);

		final int CAR_COUNT = scanner.nextInt();
		final int MOVE_COUNT = scanner.nextInt();

		return new UserInput(CAR_COUNT, MOVE_COUNT);
	}
}
