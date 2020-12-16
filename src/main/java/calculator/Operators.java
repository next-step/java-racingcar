package calculator;

import java.util.List;
import java.util.Queue;

public class Operators {
	private final Queue<Operator> operators;

	private Operators(Queue<Operator> operators) {
		this.operators = operators;
	}

	public static Operators create(List<String> operators) {
		return new Operators(QueueUtils.mapToQueue(operators, Operator::valueOfSign));
	}

	public boolean isEmpty() {
		return operators.isEmpty();
	}

	public Operator poll() {
		if (operators.isEmpty()) {
			return null;
		}

		return operators.poll();
	}
}
