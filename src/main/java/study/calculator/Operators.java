package study.calculator;

import java.util.ArrayList;
import java.util.List;

public class Operators {
	private final List<Operator> operators = new ArrayList<>();

	public Operators() {
		operators.add(new Addition());
		operators.add(new Subtraction());
		operators.add(new Multiplication());
		operators.add(new Division());
	}

	public int calculate(OperatorStatus operatorStatus, int src1, int src2) {
		Operator selectedOperator = operators.stream()
			.filter(operator -> operator.matchOperatorStatus(operatorStatus))
			.findFirst()
			.orElseThrow(IllegalArgumentException::new);

		return selectedOperator.calculate(src1, src2);
	}
}
