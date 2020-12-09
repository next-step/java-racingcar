package race.domain;

public class SimpleMovePolicy implements MovePolicy {
	@Override
	public boolean move() {
		return true;
	}

	@Override
	public int distance() {
		return INCREASE_DISTANCE_NUMBER;
	}
}
