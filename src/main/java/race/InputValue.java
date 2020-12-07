package race;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputValue {
	public static final String INPUT_NAME_SEPARATOR = ",";

	private final List<CarName> names;
	private int numberOfTryTimes;

	public InputValue(String names, int numberOfTryTimes) {
		this.names = generateCarNames(names);
		this.numberOfTryTimes = numberOfTryTimes;
	}

	public InputValue(String names) {
		this.names = generateCarNames(names);
	}

	public static InputValue ofSeparatorValues(String names) {
		return new InputValue(names);
	}

	public List<CarName> generateCarNames(String names) {
		return makeSeparatorNames(names).stream()
			.map(CarName::of)
			.collect(Collectors.toList());
	}


	private List<String> makeSeparatorNames(String names) {
		return Arrays.asList(names.split(INPUT_NAME_SEPARATOR));
	}

	public List<CarName> names() {
		return names;
	}

	public int numberOfTryTimes() {
		return numberOfTryTimes;
	}
}
