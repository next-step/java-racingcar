package racingcar;

import java.util.Scanner;

public class InputView {
	private static final String NUMBER_OF_CAR_INPUT_GUIDE = "자동차 대수는 몇 대 인가요?";
	private static final String NUMBER_OF_TRIAL_INPUT_GUIDE = "시도할 회수는 몇 회 인가요?";
	private static final Scanner scanner = new Scanner(System.in);

	public static int inputNumberOfCar() {
		System.out.println(NUMBER_OF_CAR_INPUT_GUIDE);
		return scanner.nextInt();
	}

	public static int inputNumberOfTrial() {
		System.out.println(NUMBER_OF_TRIAL_INPUT_GUIDE);
		return scanner.nextInt();
	}
}
