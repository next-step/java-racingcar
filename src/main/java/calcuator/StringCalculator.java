package calcuator;

import calcuator.validator.Validator;

public class StringCalculator {
	private static final String DELIMITER = " ";

	private static final int INDEX_OF_FIRST_OPERAND = 0;
	private static final int INDEX_OF_FIRST_OPERATION = 1;
	private static final int NEXT_INDEX = 1;
	private static final int INCREMENT_BY_TWO = 2;

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

		int result = Integer.parseInt(tokens[INDEX_OF_FIRST_OPERAND]);
		for (int i = INDEX_OF_FIRST_OPERATION; i < tokens.length; i += INCREMENT_BY_TWO) {
			Operation operation = Operation.convert(tokens[i]);
			int target = Integer.parseInt(tokens[i + NEXT_INDEX]);
			result = operation.apply(result, target);
		}
		return result;
	}
}
