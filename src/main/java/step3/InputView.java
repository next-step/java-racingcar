package step3;

import java.util.Scanner;

public class InputView {
	private final static Scanner SCANNER = new Scanner(System.in);
	private final static String QUESTION_NUMBER_OF_CARS = "자동차 대수는 몇 대 인가요?";
	private final static String QUESTION_NUMBER_OF_TRIALS = "시도할 회수는 몇 회 인가요?";

	public int[] answers() {
		int[] answers = new int[2];
		answers[0] = answerFromQuestion(QUESTION_NUMBER_OF_CARS);
		answers[1] = answerFromQuestion(QUESTION_NUMBER_OF_TRIALS);

		return answers;
	}

	private int answerFromQuestion(String question) {
		viewQuestion(question);
		int answer = SCANNER.nextInt();
		Validator.validateOverZero(answer);

		return answer;
	}

	private void viewQuestion(String question) {
		System.out.println(question);
	}
}