package calculator.operation;

import java.util.stream.Stream;

import org.apache.commons.lang3.StringUtils;

import calculator.exception.CalculatorException;

public enum Operation {
	PLUS("+"),
	MINUS("-"),
	MULTIPLY("*"),
	DIVISION("/");

	final String sign;

	Operation(String sign) {
		this.sign = sign;
	}

	public String getSign() {
		return sign;
	}

	public static void validateOperation(String operation) {
		if (StringUtils.isEmpty(operation)) {
			throw new CalculatorException("연산자가 입력되지 않았습니다.");
		}

		boolean correctOperation = Stream.of(values())
										 .anyMatch(value -> value.equals(operation));

		if (!correctOperation) {
			throw new CalculatorException("올바르지 못한 연산자가 입력되었습니다.");
		}
	}
}
