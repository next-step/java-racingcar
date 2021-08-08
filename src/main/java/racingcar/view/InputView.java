package racingcar.view;

import java.util.Scanner;

public class InputView {
	public static final String QUESTION_FOR_CAR_COUNT = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
	public static final String QUESTION_FOR_GAME_COUNT = "시도할 회수는 몇 회 인가요?";
	private final Scanner scanner;

	public InputView() {
		this.scanner = new Scanner(System.in);
	}

	public void renderQuestionOfName() {
		System.out.println(QUESTION_FOR_CAR_COUNT);
	}

	public void renderQuestionOfCount() {
		System.out.println(QUESTION_FOR_GAME_COUNT);
	}

	public String readString() {
		return this.scanner.nextLine();
	}

	public int readNumber() {
		return this.scanner.nextInt();
	}
}
