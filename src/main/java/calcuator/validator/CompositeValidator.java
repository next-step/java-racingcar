package calcuator.validator;

import java.util.Arrays;
import java.util.List;

public class CompositeValidator implements Validator {

	private final List<Validator> validators;

	public CompositeValidator() {
		this(new EmptyValidator(), new InputPatternValidator());
	}

	public CompositeValidator(Validator... validator) {
		this.validators = Arrays.asList(validator);
	}

	@Override
	public void validate(String input) {
		validators.forEach(validator -> validator.validate(input));
	}
}
