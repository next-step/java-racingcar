package racingcar.domain;

public interface ConditionStrategy {
	boolean validInput(String input) throws RuntimeException;
}
