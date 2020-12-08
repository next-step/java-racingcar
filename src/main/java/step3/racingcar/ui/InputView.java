package step3.racingcar.ui;

import java.util.Scanner;

public class InputView {

	private final Scanner scanner;

	public InputView() {
		this.scanner = new Scanner(System.in);
	}

	public int participateCarCountInput() {
		System.out.println("자동차 대수는 몇 대 인가요?");
		int participateCarCount = inputInteger();
		validateGreaterThenZero(participateCarCount);
		return participateCarCount;
	}

	public int racingExecuteCountInput() {
		System.out.println("시도할 회수는 몇 회 인가요?");
		int racingExecuteCount = inputInteger();
		validateGreaterThenZero(racingExecuteCount);
		return racingExecuteCount;
	}

	private int inputInteger() {
		try {
			return Integer.parseInt(scanner.nextLine());
		} catch (NumberFormatException e) {
			System.err.println("정수만 입력 가능합니다.");
			throw e;
		}
	}

	private void validateGreaterThenZero(final int source) {
		if (source <= 0) {
			throw new IllegalArgumentException("0 이상의 정수만 가능합니다.");
		}
	}

}
