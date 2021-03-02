package camp.nextstep.edu.module;

import static camp.nextstep.edu.util.StringUtil.*;

import camp.nextstep.edu.entity.CalculatorInput;
import camp.nextstep.edu.entity.Operation;
import camp.nextstep.edu.exception.UserException;

public class Calculator {
	public int getResult(String input) {
		CalculatorInput calculatorInput = new CalculatorInput(input);

		String operation = "";
		int result = calculatorInput.getInitialNumber();

		for (String word : calculatorInput.getInputs()) {
			String numberOrOperation = getStringIfNullBlank(word);

			if (isNumeric(numberOrOperation)) {
				result = Operation.getResult(result, Integer.parseInt(numberOrOperation), operation);
			} else if (isOperation(numberOrOperation)) {
				operation = numberOrOperation;
			} else {
				throw new UserException();
			}
		}

		return result;
	}


}
