package calcuator;

import calcuator.validator.Validator;

public class StringCalculator {
	private static final String DELIMITER = " ";

	private final Validator validator;

	public StringCalculator(Validator validator) {
		this.validator = validator;
	}

	public int calculate(String input) {
		validator.validate(input);
		return calculateValidatedInput(input);
	}

	private int calculateValidatedInput(String input) {
		String[] tokens = input.split(DELIMITER);

		int result = Integer.parseInt(tokens[0]);
		for (int i = 1; i < tokens.length; i += 2) {
			Operation operation = Operation.convert(tokens[i]);
			int target = Integer.parseInt(tokens[i + 1]);
			result = operation.apply(result, target);
		}
		return result;
	}
}
