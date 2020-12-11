package calculator.view;

import java.util.Scanner;

public class UserInput extends UserOutput {

	private static final Scanner SCANNER = new Scanner(System.in);

	public static final String GAME_RESTART = "1";

	/**
	 * 유저 게임 재시작 입력 메서드
	 * @return 유저 입력 값
	 */
	public static String userRestartGame() {

		UserOutput.printUserRestartMsg();
		return UserInput.userSystemInput();
	}

	/**
	 * 유저 문자열 계산기 문자 입력 메서드
	 * @return 유저 입력 값
	 */
	public static String userInputString() {

		UserOutput.printUserInputMsg();
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
