package racingcar.util.strategy.move;

public class CarMoveStrategy implements MoveStrategy {
	int MOVE_CONDITION = 4;

	@Override
	public boolean isMovable(int valueToMovable) {
		if (valueToMovable >= MOVE_CONDITION) {
			return true;
		}

		return false;
	}
}
