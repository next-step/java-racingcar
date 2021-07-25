package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class SimpleCalculator {
	private static final List<Character> operators = new ArrayList<>(Arrays.asList('+', '-', '*', '/'));
	List<String> splitExpressionList = new ArrayList<>();

	private static boolean isNumeric(String s) {
		int len = s.length();
		for (int i = 0; i < len; i++) {
			if (s.charAt(i) <= '0' || '9' <= s.charAt(i)) {
				return false;
			}
		}
		return true;
	}

	public int selectOperand(String expressionUnit, int expressionUnitIndex) {
		return Integer.valueOf(expressionUnit.split(" ")[expressionUnitIndex]);
	}

	public int plus(String expressionUnit) {
		return (selectOperand(expressionUnit, 0) + selectOperand(expressionUnit, 2));
	}

	public int minus(String expressionUnit) {
		return (selectOperand(expressionUnit, 0) - selectOperand(expressionUnit, 2));
	}

	public int multiply(String expressionUnit) {
		return (selectOperand(expressionUnit, 0) * selectOperand(expressionUnit, 2));
	}

	public int divide(String expressionUnit) throws NotEqualRemainderZeroException {
		int firstOperand = selectOperand(expressionUnit, 0);
		int secondOperand = selectOperand(expressionUnit, 2);
		if (firstOperand % secondOperand != 0) {
			throw new NotEqualRemainderZeroException();
		}
		return firstOperand / secondOperand;
	}

	public String calculate(String expression) throws Exception {
		checkNullValidation(expression);
		checkEmptyValidation(expression);

		splitExpressionList.clear();
		splitExpressionList.addAll(Arrays.asList(expression.split(" ")));
		checkSpaceBetweenNumberAndOperatorValidation();

		while (splitExpressionList.size() != 1) {
			String result = null;
			result = callFunctionByOperator(splitExpressionList);
			for (int i = 0; i <= 2; i++) {
				splitExpressionList.remove(0);
			}
			splitExpressionList.add(0, result);
		}
		return splitExpressionList.get(0);
	}

	private void checkNullValidation(String expression) throws Exception {
		if (expression == null) {
			throw new IllegalArgumentException();
		}
	}

	private void checkEmptyValidation(String expression) throws Exception {
		if ("".equals(expression)) {
			throw new IllegalArgumentException();
		}
	}

	private void checkSpaceBetweenNumberAndOperatorValidation() {
		for (String exp : splitExpressionList) {
			boolean isNumeric = isNumeric(exp);
			boolean isOperator = exp.length() == 1 && operators.contains(exp.charAt(0));

			if (isNumeric || isOperator) {
				continue;
			}
			throw new IllegalArgumentException();
		}
	}

	private String callFunctionByOperator(List<String> expressionUnit) throws NotEqualRemainderZeroException {
		AtomicInteger result = new AtomicInteger();
		Arrays.stream(Operator.values())
			.filter(operator -> operator.getOperator().equals(expressionUnit.get(1)))
			.forEach(operator -> result.set(operator.calculate(Integer.valueOf(expressionUnit.get(0)),Integer.valueOf(expressionUnit.get(2)))));
		return result.toString();
	}
}
