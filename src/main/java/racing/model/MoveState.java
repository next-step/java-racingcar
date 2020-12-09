package racing.model;

public enum MoveState {

	MOVE, STAY;

	public boolean isMove() {

		return this.equals(MOVE);
	}
}
