package study;

public class Car {

	private int carId;
	private String distance;

	public Car(int carId, String distance) {
		this.carId = carId;
		this.distance = distance;
	}

	public int getCarId() {
		return carId;
	}

	public String getDistance() {
		return distance;
	}

	public void go() {
		distance += "-";
	}

	public void stop() {
		distance += "";
	}
}
