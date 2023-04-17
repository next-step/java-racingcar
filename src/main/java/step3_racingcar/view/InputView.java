package step3_racingcar.view;

import java.util.Scanner;

import step3_racingcar.service.GameRule;

public class InputView {
	private final static String inputCar = "자동차 대수는 몇 대 인가요?";
	private final static String inputAttempt = "시도할 회수는 몇 회 인가요?";
	private static final Scanner scanner = new Scanner(System.in);

	public static int getCarCount() {
		System.out.println(inputCar);
		return GameRule.isAcceptableValue(scanner.nextLine());
	}

	public static int getTryCount() {
		System.out.println(inputAttempt);
		return  GameRule.isAcceptableValue(scanner.nextLine());
	}
}
