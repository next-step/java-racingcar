package calculator.expression;

import java.util.List;

public class Operators {
	private int index;
	private List<String> operators;

	public Operators(List<String> operators) {
		this.operators = operators;
	}

	public boolean hasNext() {
		return index < operators.size();
	}

	public String getNext() {
		if (!hasNext()) {
			return null;
		}

		return operators.get(index++);
	}
}
