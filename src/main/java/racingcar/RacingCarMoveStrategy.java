package racingcar;

public class RacingCarMoveStrategy implements CarMoveStrategy {
	public static final int MOVABLE_CONDITION = 4;
	private final int number;

	public RacingCarMoveStrategy(int number) {
		this.number = number;
	}

	@Override
	public boolean isMovable() {
		if (this.number >= MOVABLE_CONDITION) {
			return true;
		}
		return false;
	}
}
