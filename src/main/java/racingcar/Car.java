package racingcar;

public class Car {
	private int location;

	public Car() {
		location = 0;
	}

	public void go(MovingStrategy movingStrategy) {
		if (movingStrategy.canGo()) {
			location++;
		}
	}

	public int getLocation() {
		return location;
	}
}
