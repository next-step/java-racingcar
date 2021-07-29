package racing.view;

import java.util.Scanner;

import racing.utils.Validation;

public class RacingInputView {

	public static final String CAR_EMPTY_MESSAGE = "자동차는 최소 1대 이상이어야 한다.";
	public static final String INT_MIS_TYPE_MATCH_MESSAGE = "해당 문자는 숫자만 사용 가능합니다.";

	private static final String FIRST_REQUEST = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
	private static final String SECOND_REQUEST = "시도할 회수는 몇회인가요?";

	private final Scanner scanner;

	public RacingInputView() {
		scanner = new Scanner(System.in);
	}

	public String firstRequestView() {
		System.out.println(FIRST_REQUEST);
		String inputValue = scanner.next();
		Validation.validEmptyCheck(inputValue, CAR_EMPTY_MESSAGE);
		return inputValue;
	}

	public int secondRequestView() {
		System.out.println(SECOND_REQUEST);
		String inputValue = scanner.next();
		Validation.validIntTypeMatchCheck(inputValue, INT_MIS_TYPE_MATCH_MESSAGE);
		return toInt(inputValue);
	}

	public int toInt(String value) {
		return Integer.parseInt(value);
	}

}
