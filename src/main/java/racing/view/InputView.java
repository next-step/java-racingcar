package racing.view;

import java.util.Scanner;

import racing.controller.RacingController;

public class InputView {

	private static final Scanner scanner = new Scanner(System.in);
	private static final RacingController racingController = new RacingController();

	private InputView() {

	}

	public static int inputCarCount() {
		System.out.println("자동차 대수는 몇 대 인가요?");

		return scanner.nextInt();
	}

	public static int inputTryCount() {
		System.out.println("시도할 회수는 몇 회 인가요?");

		return scanner.nextInt();
	}

	public static void startRacing(int carCount, int tryCount) {
		racingController.start(carCount, tryCount);
	}
}
