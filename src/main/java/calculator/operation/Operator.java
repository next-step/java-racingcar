package calculator.operation;

import java.util.function.BinaryOperator;
import java.util.stream.Stream;

import org.apache.commons.lang3.StringUtils;

import calculator.exception.IllegalDividendException;
import calculator.exception.IllegalInputException;
import calculator.exception.IllegalOperatorException;

public enum Operator {
	PLUS("+", (operand1, operand2) -> operand1 + operand2),
	MINUS("-", (operand1, operand2) -> operand1 - operand2),
	MULTIPLY("*", (operand1, operand2) -> operand1 * operand2),
	DIVISION("/", (operand1, operand2) -> {
		if (operand2.equals(0)) {
			throw new IllegalDividendException("0을 제수로 사용할 수는 없습니다.");
		}
		return operand1 / operand2;
	});

	final String sign;
	final BinaryOperator<Integer> performerGetter;

	Operator(String sign, BinaryOperator<Integer> performerGetter) {
		this.sign = sign;
		this.performerGetter = performerGetter;
	}

	public static Operator getValueBySign(String userSign) {
		return Stream.of(values())
					 .filter(value -> value.sign.equals(userSign))
					 .findFirst()
					 .orElseThrow(IllegalOperatorException::new);

	}

	public static void validateOperation(String userSign) {
		if (StringUtils.isEmpty(userSign)) {
			throw new IllegalInputException("연산자가 입력되지 않았습니다.");
		}

		boolean correctOperation = Stream.of(values())
										 .anyMatch(value -> value.sign.equals(userSign));

		if (!correctOperation) {
			throw new IllegalOperatorException("올바르지 못한 연산자가 입력되었습니다.");
		}
	}

	public BinaryOperator<Integer> getPerformerGetter() {
		return performerGetter;
	}
}
