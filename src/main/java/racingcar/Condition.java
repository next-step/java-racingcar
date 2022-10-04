package racingcar;

public class Condition {
	private ConditionStrategy conditionStrategy;

	public Condition(ConditionStrategy conditionStrategy) {
		this.conditionStrategy = conditionStrategy;
	}

	public boolean validInput(String input) {
		return conditionStrategy.validInput(input);
	}
}
