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

	public String InputCarNames() {
		System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
		String carNames = scanner.nextLine();
		validateInputCarNames(carNames);
		return carNames;
	}

	private void validateInputCarNames(final String carNames) {
		if (carNames == null || carNames.isEmpty()) {
			throw new IllegalArgumentException("경주할 자동차 이름은 필수 값입니다.");
		}
	}

}
