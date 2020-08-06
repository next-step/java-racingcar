package step2;

public class DivisionCalculator implements Calculator {

	@Override
	public boolean isValidOperator(String operator) {
		return "/".equals(operator);
	}

	@Override
	public int calculate(int num1, int num2) {
		if(num2 == 0) {
			throw new ArithmeticException("나눗셈 식의 분모는 0이 될 수 없습니다.");
		}
		return num1 / num2;
	}
}
