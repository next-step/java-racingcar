package calcuator.validator;

import java.util.Arrays;
import java.util.List;

public class CompositeValidator implements Validator {

	private final List<Validator> validators;

	public CompositeValidator() {
		this(new EmptyValidator(), new InputPatternValidator());
	}

	public CompositeValidator(Validator... validators) {
		this.validators = Arrays.asList(validators);
	}

	@Override
	public void validate(String input) {
		validators.forEach(validator -> validator.validate(input));
	}
}
