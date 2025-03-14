package racingcar;

public class Car {
	private int distance;

	public Car() {
		distance = 0;
	}

	public void go() {
		if (CarMoveHandler.canGo()) {
			distance++;
		}
		OutputView.printCarDistance(distance);
	}
}
