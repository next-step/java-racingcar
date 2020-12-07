package race;

import java.util.Arrays;
import java.util.List;

public class InputValue {
	public static final String INPUT_NAME_SEPARATOR = ",";
	public static final int MAX_INPUT_NAME_LENGTH = 5;

	private final List<String> names;
	private int numberOfTryTimes;

	public InputValue(String names, int numberOfTryTimes) {
		this.names = generateNames(names);
		this.numberOfTryTimes = numberOfTryTimes;
	}

	public InputValue(String names) {
		this.names = generateNames(names);
	}

	public static InputValue ofSeparatorValues(String names) {
		return new InputValue(names);
	}

	public List<String> generateNames(String names) {
		List<String> asNames = makeSeparatorNames(names);
		validator(asNames);
		return asNames;
	}

	private List<String> makeSeparatorNames(String names) {
		return Arrays.asList(names.split(INPUT_NAME_SEPARATOR));
	}

	private void validator(List<String> asNames) {
		asNames.forEach(name -> {
			if (name.length() > MAX_INPUT_NAME_LENGTH) {
				throw new IllegalInputNameException();
			}
		});
	}

	public List<String> names() {
		return names;
	}

	public int numberOfTryTimes() {
		return numberOfTryTimes;
	}
}
