package racing.view;

import java.util.Scanner;

public class UserInput {

	private static final Scanner SCANNER = new Scanner(System.in);

	/**
	 * 유저 문자열 계산기 문자 입력 메서드
	 * @return 유저 입력 값
	 */
	public static String userInputString() {

		return UserInput.userSystemInput();
	}

	public static int userInputNumber() {

		String inputStr = UserInput.userSystemInput();

		if (!isNumber(inputStr)) {
			throw new IllegalArgumentException("숫자만 입력해 주세요.");
		}

		return Integer.parseInt(inputStr);
	}

	public static boolean isNumber(String inputNumber) {

		try {
			Integer.parseInt(inputNumber);
			return true;
		} catch (NumberFormatException numberFormatException) {
			return false;
		}
	}

	/**
	 * 유저에게 입력 받는 메서드
	 * @return 입력한 문자열
	 */
	private static String userSystemInput() {

		return SCANNER.nextLine();
	}
}
