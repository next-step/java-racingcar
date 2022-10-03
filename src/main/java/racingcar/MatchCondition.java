package racingcar;

public class MatchCondition implements ConditionStrategy {
	private static final char ASCII_ZERO = 48;
	private static final char ASCII_NINE = 57;

	@Override
	public boolean validInput(String input) {
		if (Integer.parseInt(input) < 0 || (ASCII_NINE < input.charAt(0) && input.charAt(0) < ASCII_ZERO)) {
			throw new RuntimeException();
		}
		return true;
	}
}
