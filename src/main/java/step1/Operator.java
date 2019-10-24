package step1;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public enum Operator {

	PLUS("+", BigDecimal::add),
	MINUS("-", BigDecimal::subtract),
	MULTIPLY("*", BigDecimal::multiply),
	DIVIDE("/", (leftNum, rightNum) -> {
		return leftNum.divide(rightNum, 8, RoundingMode.HALF_UP);
	});

	private final String operationExpression;
	private final BiFunction<BigDecimal, BigDecimal, BigDecimal> operate;

	Operator(String operationExpression, BiFunction<BigDecimal, BigDecimal, BigDecimal> operate) {
		this.operationExpression = operationExpression;
		this.operate = operate;
	}

	// 성능을 위한 캐싱
	private static Map<String, Operator> operators = new HashMap<>();

	static {
		for (Operator operator : Operator.values()) {
			operators.put(operator.getOperationExpression(), operator);
		}
	}

	public static Operator of(String operationExpression) {
		if (operators.containsKey(operationExpression)) {
			return operators.get(operationExpression);
		}
		throw new IllegalArgumentException();
	}

	public String getOperationExpression() {
		return this.operationExpression;
	}

	public BiFunction<BigDecimal, BigDecimal, BigDecimal> getOperate() {
		return this.operate;
	}

}
