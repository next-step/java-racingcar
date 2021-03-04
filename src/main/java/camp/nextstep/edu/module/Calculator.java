package camp.nextstep.edu.module;

import static camp.nextstep.edu.util.StringUtil.*;

import java.util.Queue;

import camp.nextstep.edu.entity.CalculatorInput;
import camp.nextstep.edu.entity.Operation;
import camp.nextstep.edu.exception.UserException;

public class Calculator {
	public int getResult(String input) {
		CalculatorInput calculatorInput = new CalculatorInput(input);

		return calculate(calculatorInput.getInputs(), calculatorInput.getInitialNumber(), "");
	}

	private int calculate(Queue<String> inputs, int result, String op) {
		if (inputs.isEmpty()) {
			return result;
		}

		String word = inputs.poll();
		if (isNumeric(word)) {
			int operationResult = Operation.getInstance(op)
				.getOperation()
				.apply(result, Integer.parseInt(word));

			return calculate(inputs, operationResult, op);
		}

		if (Operation.isOperation(word)) {
			return calculate(inputs, result, word);
		}

		throw new UserException();
	}
}
