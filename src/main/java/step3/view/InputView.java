package step3.view;

import java.util.Scanner;

public class InputView {
	private final static Scanner SCANNER = new Scanner(System.in);
	private final static String QUESTION_NUMBER_OF_CARS = "자동차 대수는 몇 대 인가요?";
	private final static String QUESTION_NUMBER_OF_TRIALS = "시도할 회수는 몇 회 인가요?";

	public static int numberOfCars() {
		return answerFromQuestion(QUESTION_NUMBER_OF_CARS);
	}

	public static int numberOfTrials() {
		return answerFromQuestion(QUESTION_NUMBER_OF_TRIALS);
	}

	private static int answerFromQuestion(String question) {
		System.out.println(question);
		int answer = SCANNER.nextInt();

		validateOverZero(answer);

		return answer;
	}

	private static void validateOverZero(int number) {
		if (number < 1) {
			throw new IllegalArgumentException("0보다 큰 숫자를 입력해주세요!");
		}
	}
}