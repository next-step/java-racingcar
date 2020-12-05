package calculator;

import util.UserInput;

public class CalculatorService {

	// 계산식 연산자
	public static final String OPERATOR_PLUS = "+";
	public static final String OPERATOR_MINUS = "-";
	public static final String OPERATOR_MULTI = "*";
	public static final String OPERATOR_MOD = "/";

	public static final String GAME_RESTART = "1";

	private int result;
	private int calculateNumber;
	private String sign;

	/**
	 * 계산을 담당하는 생성자
	 * @param firstNumber: 유저가 입력한 계산식 제일 첫번째 수
	 */
	public CalculatorService(int firstNumber) {

		this.result = firstNumber;
	}

	/**
	 * 문자열 계산기
	 * @param userInputMsg: 유저가 입력한 계산식 문자열
	 * @return 계산 결과 리턴
	 */
	public static int start(String userInputMsg) {

		// 유저가 입력한 문자열 -> " " 기준으로 숫자와 연산자를 나눔
		String[] userInputArr = userInputMsg.split(" ");
		CalculatorService calculatorService = new CalculatorService(Integer.parseInt(userInputArr[0]));

		// 유저가 입력한 계산식에서 연산자와 수 2개씩 끊어서 계산하는 반복문
		for (int i = 1; i < userInputArr.length; i = i + 2) {

			// 계산
			calculatorService.calculate(userInputArr[i], Integer.parseInt(userInputArr[i+1]));
		}

		// 결과 리턴
		return calculatorService.getResult();
	}

	/**
	 * 게임 재시작 판단 메서드
	 * @return 게임 재시작 여부(1: 재시작, 그외: 종료)
	 */
	public static boolean isStartGame() {

		return GAME_RESTART.equals(UserInput.userRestartGame());
	}

	/**
	 * 연산자와 수를 입력받아 계산하는 메서드
	 * @param signStr: 유저 입력 연산자
	 * @param calculateNumber: 유저 입력 수
	 */
	public void calculate(String signStr, int calculateNumber) {

		this.calculateNumber = calculateNumber;
		this.sign = signStr;

		calculate();
	}

	/**
	 * 사칙 연산 계산 메서드
	 */
	private void calculate() {

		if (OPERATOR_PLUS.equals(this.sign)) {
			plus();
		}

		if (OPERATOR_MINUS.equals(this.sign)) {
			minus();
		}

		if (OPERATOR_MULTI.equals(this.sign)) {
			multi();
		}

		if (OPERATOR_MOD.equals(this.sign)) {
			mod();
		}
	}

	/**
	 * 계산 결과 리턴 메서드
	 * @return 계산 결과
	 */
	public int getResult() {

		return this.result;
	}

	private void plus() {

		this.result += this.calculateNumber;
	}

	private void minus() {

		this.result -= this.calculateNumber;
	}

	private void mod() {

		this.result /= this.calculateNumber;
	}

	private void multi() {

		this.result *= this.calculateNumber;
	}
}
