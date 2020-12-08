package step2;

import java.util.Arrays;

public class Calculator {
	public long calculate(String expression) {
		// 입력값 null이거나 빈 공백문자열인지 체크
		validateInput(expression);
		String[] expressionArray = expression.split(" ");
		long result = Long.parseLong(expressionArray[0]);
		for (int i = 1; i < expressionArray.length; i+=2) {
			Operator operator = validateOperator(expressionArray[i]);
			long second = Long.parseLong(expressionArray[i+1]);
			result = operator.operation(result, second);
		}
		return result;
	}

	private Operator validateOperator(String symbol) {
		Operator operator = OperatorFactory.getOperator(symbol);
		if (operator == null) {
			throw new IllegalArgumentException("사칙연산 기호가 아닙니다.");
		}
		return operator;
	}

	private void validateInput(String s) {
		if (s == null || s.trim().equals("")) {
			throw new IllegalArgumentException("계산할 문자열을 입력해주세요.");
		}
	}
}
