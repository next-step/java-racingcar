package step5_racingcar_refactoring.view;

import java.util.Scanner;

import step5_racingcar_refactoring.service.GameRule;

public class InputView {
	private final static String inputCarNames = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
	private final static String inputAttempt = "시도할 회수는 몇 회 인가요?";
	private static final Scanner scanner = new Scanner(System.in);

	public static String[] getCarName() {
		System.out.println(inputCarNames);
		return GameRule.parseNames(scanner.nextLine());
	}

	public static int getTryCount() {
		System.out.println(inputAttempt);
		return  GameRule.isAcceptableTryValue(scanner.nextLine());
	}
}
