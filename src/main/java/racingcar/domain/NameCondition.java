package racingcar.domain;

public class NameCondition implements ConditionStrategy {
	private final int MAX_OF_NAME = 5;

	@Override
	public boolean validInput(String input) throws RuntimeException {
		if (input.length() > MAX_OF_NAME || input.isBlank()) {
			return true;
		}
		return false;
	}
}
