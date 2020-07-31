package calculator.validator;

import java.util.List;
import java.util.stream.IntStream;

import org.apache.commons.lang3.StringUtils;

import calculator.exception.IllegalInputException;
import calculator.exception.IllegalOperandException;
import calculator.operation.Operator;
import calculator.util.UserInputUtil;

public class CalculatorValidator {

	public void validate(String userInput) {
		this.validateInputValue(userInput);
		this.validateOperand(userInput);
		this.validateOperation(userInput);
	}

	private void validateInputValue(String userInput) {
		if (StringUtils.isBlank(userInput)) {
			throw new IllegalInputException("계산해야 할 내용을 입력해주세요.");
		}

		String[] splittedValueOfUserInput = userInput.split("\\s+");
		if (splittedValueOfUserInput.length == 1 || splittedValueOfUserInput.length % 2 != 1) {
			throw new IllegalInputException("계산에 필요한 입력이 유효하지 않습니다.");
		}
	}

	private void validateOperand(String userInput) {
		List<String> operands = UserInputUtil.getOperands(userInput);

		for (String operand : operands) {
			this.checkDigit(operand);
		}
	}

	private void validateOperation(String userInput) {
		List<String> signs = UserInputUtil.getSigns(userInput);
		for (String sign : signs) {
			Operator.validateOperation(sign);
		}
	}

	private void checkDigit(String operand) {
		boolean noDigit = IntStream.range(0, operand.length())
								   .anyMatch(i -> !Character.isDigit(operand.charAt(i)));

		if (noDigit) {
			throw new IllegalOperandException("계산에 필요한 피연산자가 입력되지 않습니다.");
		}
	}
}
