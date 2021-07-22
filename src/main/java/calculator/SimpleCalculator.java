package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

	public String divide(String s) throws NotEqualRemainderZero {
		int firstOperand  = selectOperand(s, 0);
		int secondOperand = selectOperand(s, 2);
		if (firstOperand % secondOperand != 0) {
			throw new NotEqualRemainderZero();
		}
		return (selectOperand(s, 0) / selectOperand(s, 2)) + "";
	}

	public String calc(String s) throws NotEqualRemainderZero {
		List<String> tempList = new ArrayList<>(Arrays.asList(s.split(" ")));

		while (tempList.size() != 1) {
			String result = null;
			result = callFunctionByOperator(tempList);
			for (int i = 0 ; i <= 2 ; i++) {
				tempList.remove(0);
			}
			tempList.add(0, result);
		}
		return tempList.get(0);
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
