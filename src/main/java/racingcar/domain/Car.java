package racingcar.domain;

public class Car {
	private static final int MAX_CAR_NAME_LENGTH = 5;
	private final String name;
	private int location;

	public Car(String name) {
		validateName(name);
		this.name = name;
		location = 0;
	}

	private void validateName(String name) {
		if (name == null || name.isBlank()) {
			throw new RuntimeException("자동차 이름은 공백일 수 없습니다.");
		}
		if (name.length() > MAX_CAR_NAME_LENGTH) {
			throw new RuntimeException("자동차 이름은 1자 이상 5자 이하만 가능합니다.");
		}
	}

	public void go(MovingStrategy movingStrategy) {
		if (movingStrategy.canGo()) {
			location++;
		}
	}

	public int getLocation() {
		return location;
	}

	public String getName() {
		return name;
	}
}
