package step2;

import java.util.Arrays;

import sun.rmi.runtime.Log;

public class Calculator {
	public long calculate(String expression) {
		// 입력값 null이거나 빈 공백문자열인지 체크
		validateInput(expression);
		String[] expressionArray = expression.split(" ");
		long result = getLongNumber(expressionArray[0]);
		for (int i = 1; i < expressionArray.length; i+=2) {
			Operator operator = validateOperator(expressionArray[i]);
			long second = getLongNumber(expressionArray[i+1]);
			result = operator.operation(result, second);
		}
		return result;
	}

	private long getLongNumber(String number) {
		try {
			if (number.startsWith("-")) {
				return Long.parseLong(number.substring(1)) * -1;
			}
			return Long.parseLong(number);
		} catch (Exception e) {
			throw new IllegalArgumentException("숫자가 아닙니다.");
		}
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
