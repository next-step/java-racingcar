package racingcar;

public class NameCondition implements ConditionStrategy {
	@Override
	public boolean validInput(String input) {
		if (input.length() > 5 || input.isBlank()) {
			throw new RuntimeException();
		}
		return true;
	}
}
