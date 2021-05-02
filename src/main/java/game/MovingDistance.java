package game;

public class MovingDistance {

	private int distance;
	private static final int MIN_RANDOM_NUMBER = 0;
	private static final int MAX_RANDOM_NUMBER = 9;

	public MovingDistance() {
	}

	public int getDistance() {
		return distance;
	}

	public void move(int movingDistance) {
		if (movingDistance < MIN_RANDOM_NUMBER || movingDistance > MAX_RANDOM_NUMBER) {
			throw new IllegalArgumentException("random 값은 0에서 9사이 숫자만 입력이 가능합니다.");
		}
		if (movingDistance >= 4) {
			this.distance += 1;
		}
	}
}
