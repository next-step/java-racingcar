package nextstep.step3.view;

import java.util.Scanner;

public class InputView {

	private static final String INPUT_MESSAGE_CAR_NUM = "자동차 대수는 몇 대 인가요?\n";
	private static final String INPUT_MESSAGE_TRY_NUM = "시도할 횟수는 몇 회 인가요?\n";
	private Scanner scanner;

	public InputView(Scanner scanner) {
		this.scanner = scanner;
	}

	public Integer getInputMessageCarNumber() {
		System.out.println(INPUT_MESSAGE_CAR_NUM);
		return scanner.nextInt();
	}

	public Integer getInputMessageTryNumber() {
		System.out.println(INPUT_MESSAGE_TRY_NUM);
		return scanner.nextInt();
	}
}
