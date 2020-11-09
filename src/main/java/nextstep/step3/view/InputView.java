package nextstep.step3.view;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class InputView {

	private static final String INPUT_MESSAGE_CAR_NAME = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
	private static final String INPUT_MESSAGE_TRY_NUM = "시도할 횟수는 몇 회 인가요?";
	private static final String WRONG_INPUT_COUNT = "시도 횟수는 숫자만 가능합니다.";
	private static final String WRONG_INPUT_CARNAME = "자동차 이름은 필수입니다.";
	private Scanner scanner;

	public InputView(Scanner scanner) {
		this.scanner = scanner;
	}

	public String getInputMessageCarName() {
		System.out.println(INPUT_MESSAGE_CAR_NAME);
		return getInputCarName();
	}

	public Integer getInputMessageTryNumber() {
		System.out.println(INPUT_MESSAGE_TRY_NUM);
		return getInputCount();
	}

	private String getInputCarName() {
		try {
			return scanner.nextLine();
		} catch (NoSuchElementException ex) {
			throw new IllegalArgumentException(WRONG_INPUT_CARNAME);
		}
	}

	private Integer getInputCount() {
		try {
			return scanner.nextInt();
		} catch (InputMismatchException ex) {
			throw new IllegalArgumentException(WRONG_INPUT_COUNT);
		}
	}
}
