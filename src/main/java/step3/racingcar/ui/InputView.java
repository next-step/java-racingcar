package step3.racingcar.ui;

import java.util.Scanner;

public class InputView {

	private final Scanner scanner;

	public InputView() {
		this.scanner = new Scanner(System.in);
	}

	private int participateCarCountInput() {
		System.out.println("자동차 대수는 몇 대 인가요?");
		int participateCarCount = inputInteger();
		validateGreaterThenZero(participateCarCount);
		return participateCarCount;
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
