package calculator;

import util.UserInput;
import util.UserOutput;

public class Calculator {

	/**
	 * 계산기 시작 메서드- 계산이 끝나면, 재시작 여부 확인
	 */
	public static void start() {

		do {
			calculateStart();
		} while (isContinue());
	}

	/**
	 * 사칙연산 계산 메서드
	 * 문자열 계산기는 사칙연산의 계산 우선순위가 아닌 입력 값에 따라 계산 순서가 결정
	 */
	private static void calculateStart() {

		// 유서 계산식 입력
		String userInputMsg = UserInput.userInputString();

		// 계산식 입력 벨리데이션
		if (isInputCorrect(userInputMsg)) {

			// 계산 시작
			int result = CalculatorService.start(userInputMsg);

			// 계산 결과 출력
			UserOutput.printCalculatorResult(result);
		}
	}

	/**
	 * 유저가 입력한 계산식 문자열이 올바른지 판단
	 * @param userInputMsg: 유저 입력 계산식 문자열
	 * @return 입력이 올바르면 True, 아니면 False
	 */
	private static boolean isInputCorrect(String userInputMsg) {

		try {
			UserInput.validCalculatorString(userInputMsg);

			return true;
		} catch (IllegalArgumentException illegalArgumentException) {

			return false;
		}
	}

	/**
	 * 게임 재시작 여부 확인 메서드
	 * @return 게임 재시작 여부(1: 재시작, 그와: 종료)
	 */
	private static boolean isContinue() {
		return CalculatorService.isStartGame();
	}
}
