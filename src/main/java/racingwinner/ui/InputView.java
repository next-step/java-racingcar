package racingwinner.ui;

import java.util.Scanner;

public class InputView {

	private final int carCount;
	private final int repeatCount;

	private static final String QUESTION_CAR_COUNT = "자동차 대수는 몇 대 인가요?";
	private static final String QUESTION_REPEAT_COUNT = "시도할 회수는 몇 회 인가요?";

	public InputView() {
		Scanner scanner = new Scanner(System.in);

		System.out.println(QUESTION_CAR_COUNT);
		this.carCount = scanner.nextInt();

		System.out.println(QUESTION_REPEAT_COUNT);
		this.repeatCount = scanner.nextInt();
	}

	public int getCarCount() {
		return carCount;
	}

	public int getRepeatCount() {
		return repeatCount;
	}

}
