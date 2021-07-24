package racingcar;

import java.util.Scanner;

public class InputView {
	private static int inputIntValue() {
		Scanner scanner = new Scanner(System.in);
		return scanner.nextInt();
	}

	public static int inputRacingCarNum() {
		System.out.println("자동차 대수는 몇 대 인가요?");
		return inputIntValue();
	}

	public static int inputTryCount() {
		System.out.println("시도할 회수는 몇 회 인가요?");
		return inputIntValue();
	}
}
