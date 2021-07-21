package study;

import java.util.Arrays;
import java.util.function.BinaryOperator;

public enum Operator {

	ADD("+", (e1, e2) -> e1 + e2),
	MINUS("-", (e1, e2) -> e1 - e2),
	MUL("*", (e1, e2) -> e1 * e2),
	DIV("/", (e1, e2) -> e1 / e2);

	private String operator;
	private BinaryOperator<Integer> operating;

	Operator(String operator, BinaryOperator<Integer> operating) {
		this.operator = operator;
		this.operating = operating;
	}

	public static Operator of (String operator) {
		return Arrays.stream(Operator.values())
			.filter(v -> v.operator.equals(operator))
			.findFirst()
			.orElseThrow(() -> new IllegalArgumentException("Operator가 잘못되었습니다."));
	}

	public Integer calc(Integer e1, Integer e2) {
		return operating.apply(e1, e2);
	}
}
