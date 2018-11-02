package calculator;

public class StringCalculator {

	public static int calculate(String text) {
		String[] values = text.split(" ");
		int result = Integer.parseInt(values[0]);
		for(int i = 1; i < values.length; i+=2) {
			result = calc(result, values[i], Integer.parseInt(values[i+1]));
		}
		return result;
	}

	private static int calc(int first, String operator, int second) {
		if("+".equals(operator)) {
			return add(first, second);
		}
		if("-".equals(operator)) {
			return subtract(first, second);
		}
		if("*".equals(operator)) {
			return multiple(first, second);
		}
		if("/".equals(operator)) {
			return divide(first, second);
		}
		throw new IllegalArgumentException("잘못된 문자입니다.");
	}

	private static int add(int first, int second) {
		return first + second;
	}

	private static int subtract(int first, int second) {
		return first - second;
	}

	private static int multiple(int first, int second) {
		return first * second;
	}

	private static int divide(int first, int second) {
		return first / second;
	}
}
