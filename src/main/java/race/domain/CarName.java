package race.domain;

public class CarName {
	public static final int MAX_INPUT_NAME_LENGTH = 5;

	private final String value;

	public CarName(String value) {
		this.value = value;
	}

	public static CarName of(String value) {
		if (!validator(value)) {
			throw new IllegalInputNameException();
		}
		return new CarName(value);
	}

	public static boolean validator(String value) {
		return value.length() <= MAX_INPUT_NAME_LENGTH;
	}

	public String getValue() {
		return value;
	}
}
