package study.calculator;

public interface Operator {

	public int calculate(int src1, int src2);

	boolean matchOperatorStatus(OperatorStatus operatorStatus);
}
