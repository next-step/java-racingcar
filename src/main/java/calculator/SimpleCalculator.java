package calculator;

public class SimpleCalculator {
	public Integer selectOperand(String s, int idx) {
		return Integer.valueOf(s.split(" ")[idx]);
	}

	public String plus(String s) {
		return (selectOperand(s, 0) + selectOperand(s, 2)) + "";
	}

	public String minus(String s) {
		return (selectOperand(s, 0) - selectOperand(s, 2)) + "";
	}

	public String multiply(String s) {
		return (selectOperand(s, 0) * selectOperand(s, 2)) + "";
	}

	public String divide(String s) {
		return (selectOperand(s, 0) / selectOperand(s, 2)) + "";
	}
}
