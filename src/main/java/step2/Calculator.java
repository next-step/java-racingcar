package step2;

public class Calculator {
	public long calculate(String expression) {
		validateInput(expression);
		String[] expressionArray = expression.split(" ");
		validateArray(expressionArray);
		long result = getLongNumber(expressionArray[0]);
		for (int i = 1; i < expressionArray.length; i+=2) {
			Operator operator = validateOperator(expressionArray[i]);
			long second = getLongNumber(expressionArray[i+1]);
			result = operator.operation(result, second);
		}
		return result;
	}

	private void validateInput(String s) {
		if (s == null || s.trim().equals("")) {
			throw new IllegalArgumentException("계산할 문자열을 입력해주세요.");
		}
	}

	private void validateArray(String[] expressionArray) {
		if (expressionArray.length < 3 || (expressionArray.length % 2 != 1)) {
			throw new IllegalArgumentException("수식을 잘못 입력하셨습니다.");
		}
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
}
