package racing.view;

import java.util.Scanner;

import racing.controller.RacingController;

public class InputView {

	private static final Scanner scanner = new Scanner(System.in);
	private static final RacingController racingController = new RacingController();

	private static int carCount;
	private static int tryCount;

	private InputView() {

	}

	public static void inputCarCount() {
		System.out.println("자동차 대수는 몇 대 인가요?");

		carCount = scanner.nextInt();
	}

	public static void inputTryCount() {
		System.out.println("시도할 회수는 몇 회 인가요?");

		tryCount = scanner.nextInt();
	}

	public static void startRacing() {
		racingController.start(carCount, tryCount);
	}
}
