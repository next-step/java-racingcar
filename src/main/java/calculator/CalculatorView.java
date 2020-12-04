package calculator;

import java.util.ArrayList;
import java.util.List;

class CalculatorView {

	public static void main(String[] args) {
		CalculatorView calculatorView = new CalculatorView();
		Long calculateResult = calculatorView.calculateByCalculator("2 + 5 - -7 * 5 / 7");
		System.out.println(calculateResult);
	}

	private final Calculator calculator;

	CalculatorView() {
		calculator = new Calculator();
	}

	Long calculateByCalculator(String formulaExpression) {
		String[] operatingElements = formulaExpression.split(" ");
		Long firstOperand = getFirstOperand(operatingElements);
		List<OperatingEntry> operatingEntryList = createOperatingEntryList(operatingElements);
		return calculator.calculate(firstOperand, operatingEntryList);
	}

	private Long getFirstOperand(String[] strings) {
		return toLongOperand(strings[0]);
	}

	List<OperatingEntry> createOperatingEntryList(String[] strings) {
		if (strings.length % 2 == 0) {
			throw new IllegalArgumentException("첫번째 피연산자 이후 연산자와 피연산자가 쌍으로 존재해야 합니다.");
		}

		List<OperatingEntry> operatingEntryList = new ArrayList<>();
		for (int i = 1; i < strings.length; i = i + 2) {
			OperatingEntry operatingEntry = createOperatingEntry(strings[i], strings[i + 1]);
			operatingEntryList.add(operatingEntry);
		}
		return operatingEntryList;
	}

	OperatingEntry createOperatingEntry(String operatorIdentifier, String stringOperand) {
		FourRuleOperator fourRuleOperator = FourRuleOperator.of(operatorIdentifier)
				.orElseThrow(() -> new IllegalArgumentException(createWrongFourRuleOperatorMessage(operatorIdentifier)));
		Long operand = toLongOperand(stringOperand);
		return OperatingEntry.of(fourRuleOperator, operand);
	}

	Long toLongOperand(String stringOperand) {
		if (stringOperand == null) {
			throw new IllegalArgumentException("operand is null");
		}

		if (stringOperand.equals(" ")) {
			throw new IllegalArgumentException("operand is space");
		}

		try {
			return Long.parseLong(stringOperand);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(e);
		}
	}

	private String createWrongFourRuleOperatorMessage(String wrongOperator) {
		return String.format("사칙연산 부호가 아닙니다: %s", wrongOperator);
	}
}
