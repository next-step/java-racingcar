package step1;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

import static step1.ScaleRule.DIVIDEND;

public enum Operator {

	PLUS("+", BigDecimal::add),
	MINUS("-", BigDecimal::subtract),
	MULTIPLY("*", BigDecimal::multiply),
	DIVIDE("/", (leftNum, rightNum) -> {
		return leftNum.divide(rightNum, DIVIDEND.getScale(), RoundingMode.HALF_UP);
	});

	private final String operationExpression;
	private final BiFunction<BigDecimal, BigDecimal, BigDecimal> operate;

	Operator(String operationExpression, BiFunction<BigDecimal, BigDecimal, BigDecimal> operate) {
		this.operationExpression = operationExpression;
		this.operate = operate;
	}

	private static Map<String, Operator> cachedOperators = new HashMap<>();

	static {
		for (Operator operator : Operator.values()) {
			cachedOperators.put(operator.operationExpression, operator);
		}
	}

	public static Operator of(String operationExpression) {
		if (cachedOperators.containsKey(operationExpression)) {
			return cachedOperators.get(operationExpression);
		}
		throw new IllegalArgumentException(String.format("%s는 존재하지 않는 연산자입니다", operationExpression));
	}

	public BigDecimal calculate(BigDecimal leftNumber, BigDecimal rightNumber) {
		return operate.apply(leftNumber, rightNumber);
	}

}
