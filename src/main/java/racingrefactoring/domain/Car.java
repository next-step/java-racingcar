package racingrefactoring.domain;

public class Car {

	private int forwardCount = 0;
	private final String name;

	public Car(String name) {
		if (CarValidator.isInvalidName(name)) {
			throw new CarNameException();
		}
		this.name = name;
	}

	public void moveForward(Moving moving) {
		if (moving.canMoveForward()) {
			forwardCount++;
		}
	}

	public int getForwardCount() {
		return forwardCount;
	}

	public String getName() {
		return name;
	}

	protected boolean isMoved() {
		return forwardCount > 0;
	}

}
