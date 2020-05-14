package calculator;

import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.Function;

public enum Operator {
	PLUS("+", (operand, otherOperand) -> operand + otherOperand),
	MINUS("-", (operand, otherOperand) -> operand - otherOperand),
	MULTIPLE("*", (operand, otherOperand) -> operand * otherOperand),
	DIVIDE("/",
			(operand, otherOperand) -> {
				if(otherOperand == 0) {
					throw new IllegalArgumentException("Division error. denominator is not zero");
				}
				return operand / otherOperand;
			}
	);
	
	private String oper;
	private BiFunction<Double, Double, Double> expression;
	
	Operator(String oper, BiFunction<Double, Double, Double> expression) {
		this.oper = oper;
		this.expression = expression;
	}
	
	public Double calculate(double operand , double otherOperand) {
		return expression.apply(operand, otherOperand);
	}
	
	public static Operator find(String oper) {
		return Arrays.stream(Operator.values())
					 .filter(enums -> enums.oper.equals(oper))
					 .findAny()
					 .orElseThrow(() -> new IllegalArgumentException("operator is invalid."));
	}

}
