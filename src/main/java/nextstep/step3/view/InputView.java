package nextstep.step3.view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {

	private static final String INPUT_MESSAGE_CAR_NUM = "자동차 대수는 몇 대 인가요?";
	private static final String INPUT_MESSAGE_TRY_NUM = "시도할 횟수는 몇 회 인가요?";
	private static final String WRONG_INPUT_COUNT = "자동차수와 시도횟수는 숫자만 가능합니다.";
	private Scanner scanner;

	public InputView(Scanner scanner) {
		this.scanner = scanner;
	}

	public Integer getInputMessageCarNumber() {
		System.out.println(INPUT_MESSAGE_CAR_NUM);
		return getInputCount();
	}

	public Integer getInputMessageTryNumber() {
		System.out.println(INPUT_MESSAGE_TRY_NUM);
		return getInputCount();
	}

	private Integer getInputCount() {
		try {
			return scanner.nextInt();
		} catch (InputMismatchException ex) {
			throw new IllegalArgumentException(WRONG_INPUT_COUNT);
		}
	}
}
