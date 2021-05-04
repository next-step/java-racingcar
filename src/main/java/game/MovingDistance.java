package game;

public class MovingDistance {

	private static final int MIN_RANDOM_NUMBER = 0;
	private static final int MAX_RANDOM_NUMBER = 9;
	private static final String DISTANCE_STR = "-";
	private int distance;


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

	public int makeRandomNumber() {
		return (int)(Math.random() * 10);
	}

	public String displayDistance() {
		StringBuilder displayDistance = new StringBuilder();
		for (int i = 0; i < this.distance; i++) {
			displayDistance.append(DISTANCE_STR);
		}
		return displayDistance.toString();
	}
}
