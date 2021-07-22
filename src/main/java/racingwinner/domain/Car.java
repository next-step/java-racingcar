package racingwinner.domain;

public class Car {

	private static final int FORWARD_STANDARD = 4;
	private int forwardCount = 0;
	private final String name;

	public Car(String name) {
		if (name.length() > 5) {
			throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.");
		}
		this.name = name;
	}

	public void moveForward() {
		int randomValue = RandomGenerator.generate();
		if (canMoveForward(randomValue)) {
			forwardCount++;
		}
	}

	public boolean canMoveForward(int randomValue) {
		return randomValue >= FORWARD_STANDARD;
	}

	public int getForwardCount() {
		return forwardCount;
	}

	public String getName() {
		return name;
	}

}
