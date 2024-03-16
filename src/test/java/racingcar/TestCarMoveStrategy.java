package racingcar;

public class TestCarMoveStrategy implements CarMoveStrategy{
	boolean input;

	public TestCarMoveStrategy(boolean input) {
		this.input = input;
	}

	@Override
	public boolean isMovable() {
		return input;
	}
}
