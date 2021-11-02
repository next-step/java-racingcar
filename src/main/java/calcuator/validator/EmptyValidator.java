package calcuator.validator;

public class EmptyValidator implements Validator {
	@Override
	public void validate(String input) {
		if (isEmpty(input)) {
			throw new IllegalArgumentException("input must not be empty");
		}
	}

	private boolean isEmpty(String input) {
		return input == null || input.isEmpty();
	}
}
