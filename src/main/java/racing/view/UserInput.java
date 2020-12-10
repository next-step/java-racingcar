package racing.view;

import java.util.Scanner;

public class UserInput {

	private static final Scanner SCANNER = new Scanner(System.in);

	/**
	 * 유저 문자열 계산기 문자 입력 메서드
	 * @return 유저 입력 값
	 */
	public static String userInput() {

		return UserInput.userSystemInput();
	}

	/**
	 * 유저에게 입력 받는 메서드
	 * @return 입력한 문자열
	 */
	private static String userSystemInput() {

		return SCANNER.nextLine();
	}
}
