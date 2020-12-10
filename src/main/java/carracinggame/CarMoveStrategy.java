package carracinggame;

public class CarMoveStrategy implements MoveStrategy {
	private final static int POSSIBLE_MOVE_CRITERIA = 4;

	@Override
	public int move(int position, int moveDistance) {
		return position + getMoveDistance(moveDistance);
	}

	private int getMoveDistance(int moveDistance) {
		return moveDistance < POSSIBLE_MOVE_CRITERIA ? 0 : moveDistance;
	}
}
