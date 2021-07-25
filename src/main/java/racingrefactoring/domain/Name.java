package racingrefactoring.domain;

public class Name {

	private final String name;

	public Name(String name) {
		if (CarValidator.isInvalidName(name)) {
			throw new CarNameException();
		}
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}

}
