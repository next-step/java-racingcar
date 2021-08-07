package step3.view;

import java.util.Scanner;

import step3.exception.InvalidCarNameException;

public class InputView {
	private final static Scanner SCANNER = new Scanner(System.in);
	private final static String QUESTION_NAME_OF_CARS = "경주할 자동차 이름을 입력하세요 (이름은 쉼표(,)를 기준으로 구분).";
	private final static String QUESTION_NUMBER_OF_TRIALS = "시도할 회수는 몇 회 인가요?";

	public static String[] nameOfCars() {
		System.out.println(QUESTION_NAME_OF_CARS);
		String nameOfCars = SCANNER.nextLine();
		String[] names = nameOfCars.split(",");

		for (String name : names) {
			validateNameOfCar(name);
		}

		return names;
	}

	public static int numberOfTrials() {
		System.out.println(QUESTION_NUMBER_OF_TRIALS);
		int answer = SCANNER.nextInt();

		validateOverZero(answer);

		return answer;
	}

	private static void validateNameOfCar(String name) {
		if (name.length() > 5) {
			throw new InvalidCarNameException("자동차 이름은 5자를 초과할 수 없어요!");
		}
	}

	private static void validateOverZero(int number) {
		if (number < 1) {
			throw new IllegalArgumentException("0보다 큰 숫자를 입력해주세요!");
		}
	}
}