package calculator.view;

public class UserOutput {

	private static final String PRINT_USER_INPUT_MSG = "계산식을 입력해주세요: ";
	private static final String PRINT_USER_CALCULATE_RESULT = "계산 결과: ";
	private static final String PRINT_NEXT_LINE = "\n";
	private static final String PRINT_TO_BE_CONTINUED = "게임을 새로 시작하려면 " + "1을 입력(아니면 종료)";

	public static final String USER_ERROR_MSG_IS_BANK = "[ERROR]User input is bank";
	public static final String USER_ERROR_MSG_IS_OPERATOR = "[ERROR]User input is not operator";
	public static final String USER_ERROR_MSG_IS_NUMBER = "[Error]User input number error";
	public static final String USER_ERROR_MSG_IS_CORRECT = "[Error]User input is not correct";

	private static void messagePrint(final String message) {

		System.out.print(message);
	}

	public static void printUserErrorMsg(String errorMsg) {

		messagePrint(errorMsg + PRINT_NEXT_LINE);
	}

	public static void printUserInputMsg() {

		messagePrint(PRINT_USER_INPUT_MSG);
	}

	public static void printCalculatorResult(int result) {

		messagePrint(PRINT_USER_CALCULATE_RESULT + result + PRINT_NEXT_LINE);
	}

	protected static void printUserRestartMsg() {

		messagePrint(PRINT_TO_BE_CONTINUED + PRINT_NEXT_LINE);
	}
}
