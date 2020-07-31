package calculator.expression;

import calculator.common.ExpressionPattern;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Expression {
	private String[] expression;
	private Numbers numbers;
	private Operators operators;

	public Expression(String expression) {
		if (!ExpressionPattern.EXP.isMatch(expression)) {
			throw new IllegalArgumentException("비정상적인 문자열 수식입니다.");
		}

		this.expression = expression.split(" ");
		separateNumberAndOperator();
	}

	private void separateNumberAndOperator() {
		List<String> operators = new ArrayList<>();
		List<Integer> numbers = new ArrayList<>();

		Stream.of(expression)
				.forEach(value -> {
					if (ExpressionPattern.OPR.isMatch(value)) {
						operators.add(value);
					} else {
						numbers.add(Integer.parseInt(value));
					}
				});

		this.numbers = new Numbers(numbers);
		this.operators = new Operators(operators);
	}

	public int getNextNumber() {
		return numbers.getNext();
	}

	public String getNextOperator() {
		return operators.getNext();
	}

	public boolean hasNextOperator() {
		return operators.hasNext();
	}

	public boolean hasNextNumber() {
		return numbers.hasNext();
	}
}