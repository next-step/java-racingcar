package calculator;

public class SimpleCalculator {
	public String plus(String s) {
		return Integer.valueOf(s.split(" ")[0]) + Integer.valueOf(s.split(" ")[2]) + "";
	}

	public String minus(String s) {
		return Integer.valueOf(s.split(" ")[0]) - Integer.valueOf(s.split(" ")[2]) + "";
	}
}
