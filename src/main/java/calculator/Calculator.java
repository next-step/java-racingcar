package calculator;

public class Calculator {


	private int result;
	private int calculateNumber;
	private CalculatorType calculatorType;


	public Calculator(int firstNumber) {

		this.result = firstNumber;
	}

	/**
	 * 문자열 계산기- 계산이 끝나면, 재시작 여부 확인
	 * @param userInputStr: 유저 입력 문자열
	 */
	public static int start(String userInputStr) throws IllegalArgumentException {

		CalculatorVaild.validCalculatorString(userInputStr);
		
		String[] userInputArr = userInputStr.split(" ");
		Calculator calculator = new Calculator(Integer.parseInt(userInputArr[0]));

		// 유저가 입력한 계산식에서 연산자와 수 2개씩 끊어서 계산하는 반복문
		for (int i = 1; i < userInputArr.length; i = i + 2) {

			// 계산
			calculator.calculate(userInputArr[i], Integer.parseInt(userInputArr[i + 1]));
		}

		// 결과 리턴
		return calculator.getResult();
	}

	/**
	 * 연산자와 수를 입력받아 계산하는 메서드
	 * @param signStr: 유저 입력 연산자
	 * @param calculateNumber: 유저 입력 수
	 */
	public void calculate(String signStr, int calculateNumber) {

		this.calculatorType = CalculatorType.getOperator(signStr);
		this.calculateNumber = calculateNumber;

		calculate();
	}

	/**
	 * 사칙 연산 계산 메서드
	 */
	private void calculate() {

		this.result = this.calculatorType.calculate(this.result, this.calculateNumber);
	}

	/**
	 * 계산 결과 리턴 메서드
	 * @return 계산 결과
	 */
	public int getResult() {

		return this.result;
	}


}
