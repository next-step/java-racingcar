package racingcar;

public class NameCondition implements ConditionStrategy {
	private final int MAX_OF_NAME = 5;
	@Override
	public boolean validInput(String input) {
		if (input.length() > MAX_OF_NAME || input.isBlank()) {
			throw new RuntimeException();
		}
		return true;
	}
}
