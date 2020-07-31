package calculator.executor;

import calculator.validator.CalculatorValidator;

public class Calculator {

	public String calculate(String inputOfUser) {
		CalculatorValidator.validateUserInput(inputOfUser);


		return null;
	}

}
