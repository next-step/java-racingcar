package racingcar.rule;

public class FixedFalseMoveRule implements MoveRule {
	@Override
	public boolean canMove() {
		return false;
	}
}
