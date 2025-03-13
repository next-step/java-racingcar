package racingcar;

public class CarModel {
	private int distance;

	public CarModel() {
		distance = 0;
	}

	public int getDistance() {
		return distance;
	}

	public void go() {
		distance++;
	}
}
