package util;

import java.util.Scanner;

public class InputView {
	private static final Scanner input = new Scanner(System.in);
	private static final String MESSAGE_GET_CAR_LIST = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
	private static final String MESSAGE_GET_REPEAT_TIME = "시도할 회수는 몇 회 인가요?";
	private static final String MESSAGE_INVALID_VALUE = "입력값이 올바르지 않습니다. 다시 입력해주세요.";
	private static final String MESSAGE_RACE_RESULT = "실행결과";
	private static final String MESSAGE_TEST_FAILURE_FOR_COMPARING_STRINGS = "[테스트 실패] 두 문자열이 서로 다릅니다: ";
	private static final String MESSAGE_TEST_FAILURE_FOR_COMPARING_OBJECTS = "[테스트 실패] 두 객체가 서로 다릅니다: ";
	private static final String MESSAGE_TEST_FAILURE_FOR_NOT_EXPECTED_VALUE = "[테스트 실패] 기대값과 다릅니다: ";

	public static String getCarList() {
		System.out.println(MESSAGE_GET_CAR_LIST);
		return input.nextLine();
	}

	public static String getRepeatTime() {
		System.out.println(MESSAGE_GET_REPEAT_TIME);
		return input.nextLine();
	}

	public static void getErrorMessage() {
		System.out.println(MESSAGE_INVALID_VALUE);
	}

	public static void getRaceResult() {
		System.out.println(MESSAGE_RACE_RESULT);
	}

	public static String getTestFailureMessage(String testType) {
		if ("STRING".equals(testType)) {
			return MESSAGE_TEST_FAILURE_FOR_COMPARING_STRINGS;
		}
		if ("OBJECT".equals(testType)) {
			return MESSAGE_TEST_FAILURE_FOR_COMPARING_OBJECTS;
		}
		return MESSAGE_TEST_FAILURE_FOR_NOT_EXPECTED_VALUE;
	}
}
