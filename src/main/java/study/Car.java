package study;

public class Car {

	private int carId;
	private int distance;

	public Car(int carId, int distance) {
		this.carId = carId;
		this.distance = distance;
	}

	public int getDistance() {
		return distance;
	}

	public void go() {
		distance += 1;
	}

}
