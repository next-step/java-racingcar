package racing.view;

import java.util.Scanner;

public class InputView {

	public static GameRequest inputGameRequest() {
		try (Scanner scanner = new Scanner(System.in)) {
			return new GameRequest(inputCarCount(scanner), inputTimes(scanner));
		}
	}

	private static int inputCarCount(Scanner scanner) {
		System.out.println("자동차 대수는 몇 대 인가요?");
		return scanner.nextInt();
	}

	private static int inputTimes(Scanner scanner) {
		System.out.println("시도할 회수는 몇 회 인가요?");
		return scanner.nextInt();
	}
}
