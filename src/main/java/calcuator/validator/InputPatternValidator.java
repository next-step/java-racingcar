package calcuator.validator;

import java.util.regex.Pattern;

public class InputPatternValidator implements Validator {
	private static final Pattern PATTERN = Pattern.compile("^(\\d+[ ][-+*/][ ])+\\d+$");

	@Override
	public void validate(String input) {
		if (!PATTERN.matcher(input).matches()) {
			throw new IllegalArgumentException("invalid input pattern");
		}
	}
}
