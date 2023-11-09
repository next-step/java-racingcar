package racingcar;

public class Car {
	private final String name;
	private int location;
	private final static int MOVABLE_LOWER_BOUND = 4;
	private final static int CHARACTER_LIMIT = 5;

	public Car(String name, int location) {
		validate(name);
		this.name = name;
		this.location = location;
	}

	public String getName() {
		return name;
	}

	public int getLocation() {
		return location;
	}

	public void move(int random) {
		if (isOverLowerBound(random)) {
			moveForward();
		}
	}

	private void moveForward() {
		this.location++;
	}

	private boolean isOverLowerBound(int num) {
		return num >= MOVABLE_LOWER_BOUND;
	}

	private void validate(String name) {
		if (CHARACTER_LIMIT < name.length()) {
			throw new IllegalArgumentException("이름은 5글자를 초과할 수 없습니다.");
		}
	}
}
