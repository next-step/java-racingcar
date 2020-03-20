package racingGame.ui;

import java.util.Scanner;

public class InputView {
	private static String GET_COUNT_OF_CARS_MSG = "자동차 대수는 몇 대 인가요?";
	private static String GET_TIMES_OF_CARS_GO_MSG = "시도할 회수는 몇 회 인가요?";

	private int carCount;
	private int racingTime;

	public void startInput(){
		Scanner scanner = new Scanner(System.in);
		System.out.println(GET_COUNT_OF_CARS_MSG);
		carCount = scanner.nextInt();
		System.out.println(GET_TIMES_OF_CARS_GO_MSG);
		racingTime = scanner.nextInt();
	}

	public int getCarCount() {
		return carCount;
	}

	public int getRacingTime() {
		return racingTime;
	}
}
