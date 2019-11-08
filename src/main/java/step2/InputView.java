package step2;

import java.util.Scanner;

public class InputView {

	private final int MINIMUM_CAR_COUNT = 2;

	private final int MINIMUM_MOVE_COUNT = 1;

	public UserInput getUserInput() {
		Scanner scanner = new Scanner(System.in);

		System.out.println("자동차 대수는 몇 대인가요?");
		final int CAR_COUNT = scanner.nextInt();
		System.out.println("시도할 횟수는 몇 회인가요?");
		final int MOVE_COUNT = scanner.nextInt();

		if (CAR_COUNT < MINIMUM_CAR_COUNT || MOVE_COUNT < MINIMUM_MOVE_COUNT) {
			throw new IllegalArgumentException();
		}

		return new UserInput(CAR_COUNT, MOVE_COUNT);
	}
}
