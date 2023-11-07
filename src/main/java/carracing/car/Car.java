package carracing.car;

public class Car {
	private static final int MOVING_DISTANCE = 1;
	private static final int NAME_LENGTH_MIN = 1;
	private static final int NAME_LENGTH_MAX = 5;
	private int movingDistance;
	private final String name;

	public Car(String name) {
		this(0, name);
	}

	public Car(int movingDistance, String name) {
		checkNameLengthIsValid(name);
		this.movingDistance = movingDistance;
		this.name = name;
	}

	private void checkNameLengthIsValid(String name) {
		if (isNameLengthInvalid(name)) {
			throw new IllegalArgumentException(
					String.format("이름은 %d ~ %d 자리이어야 합니다", NAME_LENGTH_MIN, NAME_LENGTH_MAX)
			);
		}
	}

	private boolean isNameLengthInvalid(String name) {
		return name == null || name.length() < NAME_LENGTH_MIN || name.length() > NAME_LENGTH_MAX;
	}

	public void move(MovingStrategy movingStrategy) {
		if (movingStrategy.isPossible()) {
			moveDistance();
		}
	}

	private void moveDistance() {
		this.movingDistance += MOVING_DISTANCE;
	}

	public int movingDistance() {
		return this.movingDistance;
	}

	public String name() {
		return this.name;
	}
}
