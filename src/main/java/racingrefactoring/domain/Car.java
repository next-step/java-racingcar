package racingrefactoring.domain;

public class Car {

	private final Name name;
	private ForwardCount forwardCount = new ForwardCount();

	public Car(String name) {
		this.name = new Name(name);
	}

	public Car(String name, int forwardCount) {
		this.name = new Name(name);
		this.forwardCount = new ForwardCount(forwardCount);
	}

	public void moveForward(Moving moving) {
		if (moving.canMoveForward()) {
			forwardCount.increase();
		}
	}

	public int forwardCount() {
		return forwardCount.value();
	}

	public String name() {
		return name.toString();
	}

	public boolean isMoved() {
		return forwardCount.greaterThan(0);
	}

	public boolean isWinner(int winnerCount) {
		return forwardCount.isSame(winnerCount);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Car car = (Car) o;
		return name.equals(car.name);
	}

}
