package racingrefactoring.domain;

public class Car {

	private final Name name;
	private final ForwardCount forwardCount = new ForwardCount();

	public Car(String name) {
		this.name = new Name(name);
	}

	public void moveForward(Moving moving) {
		if (moving.canMoveForward()) {
			forwardCount.increase();
		}
	}

	public int getForwardCount() {
		return forwardCount.count();
	}

	public String name() {
		return name.toString();
	}

	protected boolean isMoved() {
		return forwardCount.greatThan(0);
	}

}
