package calculator;

public class MultipleOperator implements Operator {
	@Override
	public long operation(long a, long b) {
		return a * b;
	}
}
