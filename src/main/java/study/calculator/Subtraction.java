package study.calculator;

public class Subtraction implements Operator {

	@Override
	public int calculate(int src1, int src2) {
		return src1 - src2;
	}
}
