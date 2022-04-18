package racingcar.domain;

public class MoveCount {
	private static int DEFULT_MOVE = 0;
	private final String MOVE_DEFAULT_STRING = "-";
	private int move;

	public MoveCount() {
		this.move = DEFULT_MOVE;
	}

	public void add() {
		move++;
	}

	public int count() {
		return move;
	}

	@Override
	public String toString() {
		return MOVE_DEFAULT_STRING.repeat(move);
	}
}
