package calculator.executor;

import java.util.Arrays;
import java.util.List;

import calculator.exception.CalculatorException;
import calculator.operation.Operator;
import calculator.util.UserInputUtil;
import calculator.validator.CalculatorValidator;

public class Calculator {
	private CalculatorValidator validator;

	public Calculator() {
		this.validator = new CalculatorValidator();
	}

	public int execute(String userInput) {
		validator.validate(userInput);

		List<String> operands = UserInputUtil.getOperands(userInput);
		List<String> signs = UserInputUtil.getSigns(userInput);
		int total = Integer.parseInt(operands.get(0));

		for (int i = 0; i < signs.size(); i++) {
			total = this.calculate(total,
								   Arrays.asList(signs.get(i), operands.get(i + 1)));
		}

		return total;
	}

	private int calculate(int currentTotal, List<String> signAndOperand) {
		if (signAndOperand == null || signAndOperand.size() != 2) {
			throw new CalculatorException("계산에 필요한 연산자와 피연산자를 각각 하나씩 넣어주세요.");
		}

		Operator operator = Operator.getValueBySign(signAndOperand.get(0));
		return operator.getPerformerGetter()
					   .apply(currentTotal,
							  Integer.parseInt(signAndOperand.get(1)));
	}

}
