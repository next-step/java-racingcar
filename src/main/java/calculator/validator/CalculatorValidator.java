package calculator.validator;

import java.util.List;
import java.util.stream.IntStream;

import org.apache.commons.lang3.StringUtils;

import calculator.exception.CalculatorException;
import calculator.operation.Operation;
import calculator.util.OperationOperandSeparator;

public class CalculatorValidator {

	public static void validateUserInput(String userInput) {
		if (StringUtils.isBlank(userInput)) {
			throw new CalculatorException("계산해야 할 내용을 입력해주세요.");
		}

		String[] splittedValueOfUserInput = userInput.split("\\s+");
		if (splittedValueOfUserInput.length == 1 || splittedValueOfUserInput.length % 2 != 1) {
			throw new CalculatorException("계산에 필요한 입력이 유효하지 않습니다.");
		}

		validateOperand(splittedValueOfUserInput);
		validateOperation(splittedValueOfUserInput);
	}

	private static void validateOperand(String[] splittedValueOfUserInput) {
		List<String> operands = OperationOperandSeparator.getOperands(splittedValueOfUserInput);

		for (String operand : operands) {
			validateDigit(operand);
		}
	}

	private static void validateDigit(String operand) {
		boolean noDigit = IntStream.range(0, operand.length())
								   .anyMatch(i -> !Character.isDigit(operand.charAt(i)));

		if (noDigit) {
			throw new CalculatorException("계산에 필요한 피연산자가 입력되지 않습니다.");
		}
	}

	private static void validateOperation(String[] splittedValueOfUserInput) {
		List<String> operations = OperationOperandSeparator.getOperations(splittedValueOfUserInput);
		for (String operation : operations) {
			Operation.validateOperation(operation);
		}
	}
}
