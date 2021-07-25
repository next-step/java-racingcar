package racingcar.view;

import java.util.Scanner;

public class InputView {
	private static Scanner scanner = new Scanner(System.in);

	private int inputIntValue() {
		return scanner.nextInt();
	}

	public int inputRacingCarNum() {
		System.out.println("자동차 대수는 몇 대 인가요?");
		return inputIntValue();
	}

	public int inputTryCount() {
		System.out.println("시도할 회수는 몇 회 인가요?");
		return inputIntValue();
	}

	public void scannerClose() {
		scanner.close();
	}
}
