package race;

public class SimpleMovePolicy implements MovePolicy {
	private static final int INCREASE_DISTANCE = 1;

	@Override
	public boolean move() {
		return true;
	}

	@Override
	public int distance() {
		return INCREASE_DISTANCE;
	}
}
