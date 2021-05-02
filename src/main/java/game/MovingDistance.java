package game;

public class MovingDistance {

	private int distance = 0;
	private static final int MIN_RANDOM_NUMBER = 0;
	private static final int MAX_RANDOM_NUMBER = 9;

	public MovingDistance(int distance) {
		if (distance < MIN_RANDOM_NUMBER || distance > MAX_RANDOM_NUMBER) {
			throw new IllegalArgumentException("random 값은 0에서 9사이 숫자만 입력이 가능합니다.");
		}
		this.distance = distance;
	}

	public int getDistance() {
		return distance;
	}
}
