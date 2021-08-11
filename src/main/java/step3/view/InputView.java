package step3.view;

import java.util.Scanner;

import step3.exception.InvalidInputNumberException;

public class InputView {
	private final static Scanner SCANNER = new Scanner(System.in);
	private final static String QUESTION_NAME_OF_CARS = "경주할 자동차 이름을 입력하세요 (이름은 쉼표(,)를 기준으로 구분).";
	private final static String QUESTION_NUMBER_OF_TRIALS = "시도할 회수는 몇 회 인가요?";
	private final static String EXCEPTION_UNDER_ONE = "0보다 큰 숫자를 입력해주세요!";

	public static String nameOfCars() {
		System.out.println(QUESTION_NAME_OF_CARS);
		return SCANNER.nextLine();
	}

	public static int numberOfTrials() {
		System.out.println(QUESTION_NUMBER_OF_TRIALS);
		int answer = SCANNER.nextInt();

		validateOverZero(answer);

		return answer;
	}

	private static void validateOverZero(int number) {
		if (number < 1) {
			throw new InvalidInputNumberException(EXCEPTION_UNDER_ONE);
		}
	}
}