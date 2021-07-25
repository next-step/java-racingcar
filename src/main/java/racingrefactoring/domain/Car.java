package racingrefactoring.domain;

public class Car {

	private int forwardCount = 0;
	private final Name name;

	public Car(String name) {

		this.name = new Name(name);
	}

	public void moveForward(Moving moving) {
		if (moving.canMoveForward()) {
			forwardCount++;
		}
	}

	public int getForwardCount() {
		return forwardCount;
	}

	public String name() {
		return name.toString();
	}

	protected boolean isMoved() {
		return forwardCount > 0;
	}

}
