package util;

public class UserOutput {

	private static final String PRINT_USER_INPUT_MSG = "계산식을 입력해주세요.";

	private static final String PRINT_NEXT_LINE = "\n";

	private static void messagePrint(final String message) {

		System.out.print(message);
	}

	public static void printUserInputMsg() {

		messagePrint(PRINT_USER_INPUT_MSG);
	}

	public static void printNextLine() {

		messagePrint(PRINT_NEXT_LINE);
	}

}
