package calculator;

import calculator.model.Calculator;
import calculator.view.UserInput;
import calculator.view.UserOutput;

public class CalculatorMain {

	public static void main(String[] args) {

		do {
			// 계산기 시작
			calculateStart();

		} while (isContinue());
	}

	private static void calculateStart() {

		try {

			// 유저 입력 // 계산 결과 리턴 // 입력 에러시 illegalArgumentException 발생
			int result = Calculator.start(UserInput.userInputString());

			// 메세지 출력
			UserOutput.printCalculatorResult(result);

		} catch (IllegalArgumentException illegalArgumentException) {

			// 메세지 출력
			UserOutput.printUserErrorMsg(illegalArgumentException.getMessage());
		}
	}

	/**
	 * 게임 재시작 여부 확인 메서드
	 * @return 게임 재시작 여부(1: 재시작, 그와: 종료)
	 */
	private static boolean isContinue() {
		return UserInput.GAME_RESTART.equals(UserInput.userRestartGame());
	}
}
