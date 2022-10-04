package racingcar;

public class Condition {
	private static ConditionStrategy conditionStrategy;

	public Condition(ConditionStrategy conditionStrategy) {
		this.conditionStrategy = conditionStrategy;
	}

	public static boolean validInput(String input) {
		return conditionStrategy.validInput(input);
	}
}
