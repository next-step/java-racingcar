package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SimpleCalculator {
	private static final List<Character> opList = new ArrayList<>(Arrays.asList('+', '-', '*', '/'));
	List<String> splitExpressionList = new ArrayList<>();

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

	public String divide(String s) throws NotEqualRemainderZero {
		int firstOperand  = selectOperand(s, 0);
		int secondOperand = selectOperand(s, 2);
		if (firstOperand % secondOperand != 0) {
			throw new NotEqualRemainderZero();
		}
		return (selectOperand(s, 0) / selectOperand(s, 2)) + "";
	}

	public String calc(String s) throws Exception {
		checkSpaceValidation(s);

		splitExpressionList.clear();
		splitExpressionList.addAll(Arrays.asList(s.split(" ")));
		checkSpaceBetweenNumberAndOperatorValidation();

		while (splitExpressionList.size() != 1) {
			String result = null;
			result = callFunctionByOperator(splitExpressionList);
			for (int i = 0 ; i <= 2 ; i++) {
				splitExpressionList.remove(0);
			}
			splitExpressionList.add(0, result);
		}
		return splitExpressionList.get(0);
	}

	private void checkSpaceValidation(String s) throws Exception {
		if (s == null) {
			throw new IllegalArgumentException();
		}

		int whiteSpaceCount = 0;
		for (int i = 0; i < s.length() ; i++) {
			if (Character.isWhitespace(s.charAt(i))) {
				whiteSpaceCount++;
			}
		}
		if (whiteSpaceCount == s.length()) {
			throw new IllegalArgumentException();
		}
	}

	private void checkSpaceBetweenNumberAndOperatorValidation() {
		for (String exp : splitExpressionList) {
			if (isNumeric(exp)) {
				continue;
			}

			if (exp.length() == 1 && opList.contains(exp.charAt(0))) {
				continue;
			}

			throw new IllegalArgumentException();
		}
	}

	private static boolean isNumeric(String s) {
		int len = s.length();
		for (int i = 0 ; i < len ; i++) {
			if (s.charAt(i) <= '0' || '9' <= s.charAt(i)) {
				return false;
			}
		}
		return true;
	}

	private String callFunctionByOperator(List<String> tempList) throws NotEqualRemainderZero {
		String result = null;
		if ("+".equals(tempList.get(1))) {
			result = plus(tempList.get(0) + " + " + tempList.get(2));
		}
		if ("-".equals(tempList.get(1))) {
			result = minus(tempList.get(0) + " - " + tempList.get(2));
		}
		if ("*".equals(tempList.get(1))) {
			result = multiply(tempList.get(0) + " * " + tempList.get(2));
		}
		if ("/".equals(tempList.get(1))) {
			result = divide(tempList.get(0) + " / " + tempList.get(2));
		}
		return result;
	}
}
